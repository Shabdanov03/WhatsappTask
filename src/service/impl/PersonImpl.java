package service.impl;

import classes.Passport;
import classes.Person;
import enums.Country;
import enums.Gender;
import service.PersonService;

import java.time.LocalDate;
import java.util.*;

public class PersonImpl implements PersonService {
    public static Scanner scanner = new Scanner(System.in);
    private List<Person> personList = new ArrayList<>();
    private List<Passport> passportList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Passport> getPassportList() {
        return passportList;
    }

    public void setPassportList(List<Passport> passportList) {
        this.passportList = passportList;
    }

    @Override
    public String createdDB(List<Person> people, List<Passport> passports) {
        this.personList = people;
        this.passportList = passports;
        return "Successfully created ! ";
    }

    @Override
    public String createdPerson() {
        System.out.println("Enter by id :");
        int id = scanner.nextInt();
        try {
            for (Passport passport : passportList) {
                if (passport.getId() == id) {
                   throw new Exception();
                }
            }
        }catch (Exception e){
            return " This id already exists !";
        }
        System.out.println(" Enter by firstName : ");
        String firstName = scanner.next();
        System.out.println(" Enter by lastName :");
        String lastName = scanner.next();
        System.out.println(" year_month_day : ");
        LocalDate dateOfBirth = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println("1. Male. 2. Female");
        System.out.println(" Enter by command :");
        int num = scanner.nextInt();
        Gender gender = null;
        switch (num) {
            case 1 -> gender = Gender.MALE;
            case 2 -> gender = Gender.FEMALE;
            default -> System.out.println(" No such gender !");
        }
        System.out.println("Select City :\n1.Bishkek. 2.Chui. 3.Osh. 4.Talas. 5.Batken." +
                " 6.Jalal-Abad. 7.Naryn. 8.Yssyk-Kol");
        System.out.println("Enter by command :");
        int number = scanner.nextInt();
        Country country = null;
        switch (number) {
            case 1 -> country = Country.BISHKEK;
            case 2 -> country = Country.CHUI;
            case 3 -> country = Country.OSH;
            case 4 -> country = Country.TALAS;
            case 5 -> country = Country.BATKEN;
            case 6 -> country = Country.JALAL_ABAD;
            case 7 -> country = Country.NARYN;
            case 8 -> country = Country.YSSYK_KOL;
            default -> System.out.println(" No such region !");
        }
            System.out.println("Enter by phone number |+996| : ");
            String phoneNumber = scanner.next();
            try {
            for (Person person : personList) {
                if (person.getPhoneNumber().equals(phoneNumber)) {
                    return " This phoneNumber already exists !";
                }if (!(phoneNumber.startsWith("+996"))) {throw new Exception();}
            }
        }catch (Exception e){
           return " Phone number can start +996  !";
        }
        Map<String, String> contacts = new HashMap<>();
        personList.add(new Person(phoneNumber, contacts, firstName, lastName, id, dateOfBirth, gender, country));
        passportList.add(new Passport(firstName, lastName, id, dateOfBirth, gender, country));
        return "Successful created ! ";
    }

    @Override
    public String removePerson() {
        boolean isRemove = false;
        System.out.println("Enter name :");
        String name = scanner.next();
        for (Person person : personList) {
            if (person.getFirstName().equals(name)) {
                personList.remove(person);
                passportList.remove(person);
                isRemove = true;
                break;
            }
        }
        return isRemove ? "Successfully removed!" : "Removed Failed!";
    }

    @Override
    public List<Person> getOllPerson() {
        return this.personList;
    }

    @Override
    public String addContacts() {
        System.out.println(" Whose contact to add ?  ");
        String name = scanner.next();
        for (Person person : personList) {
            if (person.getFirstName().equals(name)) {
                System.out.println(" Enter phone number |+996| :");
                String phoneNumber = scanner.next();
                for (Person person1 : personList) {
                    if (person1.getPhoneNumber().equals(phoneNumber)) {
                        if (!(person.getPhoneNumber().equals(phoneNumber))) {
                            System.out.println("Enter  contact name :");
                            String contactName = scanner.next();
                            if (person.getContacts().size() > 0) {
                                person.getContacts().put(phoneNumber, contactName);
                                return "Successfully added !";
                            } else {
                                Map<String, String> contact = new HashMap<>();
                                contact.put(phoneNumber, contactName);
                                contact.putAll(person.getContacts());
                                person.setContacts(contact);
                                return "Successfully added !";
                            }
                        } else {
                            return " This is your Phone Number ! ";
                        }
                    }
                }
            }
        }
        return " Added Failed  ! ";
    }

    @Override
    public void getOllPersonGenderAndCountry() {
        for (Person person : personList) {
            System.out.println("\n Gender : \n" + person.getFirstName() + "  " + person.getGender());
            System.out.println("------------------------------------------------------");
            System.out.println("\n Country : \n" + person.getFirstName() + "  " + person.getCountry());
        }

    }


    @Override
    public List<Country> getOllCountry() {
        List<Country> countryList = new ArrayList<>(List.of(Country.BATKEN, Country.BISHKEK, Country.CHUI,
                Country.NARYN, Country.JALAL_ABAD, Country.OSH, Country.TALAS, Country.YSSYK_KOL));
        return countryList;
    }

    @Override
    public Map<String, String> getOllContacts() {
        for (Person person : personList) {
            return person.getContacts();
        }
        return null;
    }

    @Override
    public List<Person> getPersonFindByName() {
        List<Person> personList1 = new ArrayList<>();
        try {
            System.out.println("Enter name: ");
            String name = scanner.next();
            if (name.matches("[a-zA-Z]*")) {
                for (Person person : this.personList) {
                    if (person.getFirstName().equals(name)) {
                        personList1.add(person);
                    }
                }
            } else {
                System.out.println("Incorrect input!");
            }if (personList1.isEmpty()) throw new Exception();
        } catch (Exception e) {
            System.out.println("There is no such passport !");
        }
        return personList1;
    }
}
