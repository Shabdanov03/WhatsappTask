package service;

import classes.Passport;
import classes.Person;
import enums.Country;
import enums.Gender;

import java.util.List;
import java.util.Map;

public interface PersonService {

  String createdDB(List<Person> people, List<Passport> passports);
  String createdPerson();
  String removePerson();
  List<Person> getOllPerson();
  String addContacts();
  void getOllPersonGenderAndCountry();
  List<Country> getOllCountry();
  Map<String, String> getOllContacts();
  List<Person> getPersonFindByName();




 }
