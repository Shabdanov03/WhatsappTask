package service;

import classes.Passport;
import classes.Person;
import classes.Profile;
import classes.WhatsUp;
import enums.Status;
import service.impl.PersonImpl;

import java.util.List;

public interface WhatsapService {


    String cratedWhatsapp();

    String removeWhatsUpProfile();

    String loginWhatsapp();

    List<Profile> getOllProfile();

    String changeStatus();

    String getChat(List<Person> personList) throws Exception;

    List<Profile> findByProfile();
}
