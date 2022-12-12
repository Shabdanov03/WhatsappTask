package classes;

import enums.Country;
import enums.Gender;

import java.time.LocalDate;

public class Passport {

   private String firstName;
   private String lastName;
   private int id;
   private LocalDate dateOfBirth;
   private Gender gender;
   private Country country;

   public Passport(){

   }

    public Passport(String firstName, String lastName,int id, LocalDate dateOfBirth, Gender gender, Country country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id= id;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.country = country;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return " \nfirstName :" + firstName +
                "\n lastName :" + lastName +
                "\n id :"+id+
                "\n dateOfBirth :" + dateOfBirth +
                "\n gender :" + gender +
                "\n country :" + country;
    }
}
