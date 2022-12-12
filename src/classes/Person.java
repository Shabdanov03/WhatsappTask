package classes;

import enums.Country;
import enums.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Person extends Passport{

    private String phoneNumber;
    private Map<String,String> contacts;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String,String> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String,String> contacts) {
        this.contacts = contacts;
    }
    public Person (){

    }
    public Person(String phoneNumber,Map<String,String> contacts, String firstName, String lastName, int id, LocalDate dateOfBirth, Gender gender, Country country) {
        super(firstName, lastName, id, dateOfBirth, gender, country);
        this.phoneNumber = phoneNumber;
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return " \n  Person : \n" + super.toString()+
                "\n phoneNumber :" + phoneNumber +
                "\n contacts :" + contacts +
                "\n============================";
    }
}
