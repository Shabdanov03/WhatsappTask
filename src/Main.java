import classes.Passport;
import classes.Person;
import classes.Profile;
import classes.WhatsUp;
import enums.Country;
import enums.Gender;
import enums.Status;
import service.impl.PersonImpl;
import service.impl.Whatsapimpl;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static PersonImpl personimpl = new PersonImpl();
    private static Whatsapimpl whatsapimpl = new Whatsapimpl();

    public static void main(String[] args) throws Exception {

        Map<String, String> contact = new HashMap<>();
        List<Person> people = new ArrayList<>();
        people.add(new Person("+996501393467", contact, "Ilim", "Shabdanov", 1,
                LocalDate.of(2003, 10, 3), Gender.MALE, Country.TALAS));

        List<Passport> passports = new ArrayList<>();
        passports.add(new Passport("Ilim", "Shabdanov", 1, LocalDate.of(2003, 10, 3),
                Gender.MALE, Country.TALAS));

        while (true) {
            System.out.println(""" 
                    =======================COMMANDS=======================
                    1.CREATED DATA BASE :
                    2.CREATED PASSPORT :
                    3.REMOVE PERSON :
                    4.GET OLL PERSON : 
                    5.ADD CONTACTS :
                    6.GET OLL GENDER AND CITY : 
                    7.GET OLL CONTACTS :
                    8.FIND A PERSON BY NAME : :
                    9.GET OLL CITY :
                    --------------------
                    10.INSTALL WHATSAPP :
                    11.DELETE PROFILE :
                    12.LOGIN WITH PASSWORD : 
                    13.GET OLL PROFILE :
                    14.CHANGE STATUS :
                    15.get ----- Chat
                    16.FIND PROFILE BY NICK NAME :
                     """);
            System.out.print(" Enter by command :");
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> System.out.println(personimpl.createdDB(people, passports));
                case 2 -> System.out.println(personimpl.createdPerson());
                case 3 -> System.out.println(personimpl.removePerson());
                case 4 -> System.out.println(personimpl.getOllPerson());
                case 5 -> System.out.println(personimpl.addContacts());
                case 6 -> personimpl.getOllPersonGenderAndCountry();
                case 7 -> System.out.println(personimpl.getOllContacts());
                case 8 -> System.out.println(personimpl.getPersonFindByName());
                case 9 -> System.out.println(personimpl.getOllCountry());
                case 10 -> System.out.println(whatsapimpl.cratedWhatsapp());
                case 11 -> System.out.println(whatsapimpl.removeWhatsUpProfile());
                case 12 -> System.out.println(whatsapimpl.loginWhatsapp());
                case 13 -> System.out.println(whatsapimpl.getOllProfile());
                case 14 -> System.out.println(whatsapimpl.changeStatus());
                case 15 -> System.out.println(whatsapimpl.getChat(personimpl.getOllPerson()));
                case 16 -> System.out.println(whatsapimpl.findByProfile());
                default -> System.out.println("No such command !");

            }

        }
    }
}