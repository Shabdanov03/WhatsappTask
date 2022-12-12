package service.impl;

import classes.Person;
import classes.Profile;
import classes.WhatsUp;
import enums.Status;

import java.util.*;

import static enums.Status.TO_THE_CINEMA;


public class Whatsapimpl implements service.WhatsapService {
    private static Scanner scanner = new Scanner(System.in);
    private List<Profile> profileList = new ArrayList<>();
    private List<WhatsUp> whatsUpList = new ArrayList<>();

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public List<WhatsUp> getWhatsUpList() {
        return whatsUpList;
    }

    public void setWhatsUpList(List<WhatsUp> whatsUpList) {
        this.whatsUpList = whatsUpList;
    }

    @Override
    public String cratedWhatsapp() {
        PersonImpl person = new PersonImpl();
        List<Person> personList = person.getPersonList();
        System.out.println("Enter by id :");
        int id = scanner.nextInt();
        for (Person person1 : personList) {
            if (!(person1.getId() == id)) {
                return "This id already exists ! ";
            }
        }
        System.out.println(" Enter by nick Name : ");
        String nickName = scanner.next();
        System.out.println("Enter by password :");
        String password = scanner.next();
        System.out.println("Select status : \n1.CODING .2.HELLO .3.IN_GYM. 4.SLEEP. 5.TO_THE_CINEMA. 6.WORKING.");
        int num = scanner.nextInt();
        Status status = null;
        switch (num) {
            case 1 -> status = Status.CODING;
            case 2 -> status = Status.HELLO;
            case 3 -> status = Status.IN_GYM;
            case 4 -> status = Status.SLEEP;
            case 5 -> status = TO_THE_CINEMA;
            case 6 -> status = Status.WORKING;
            default -> System.out.println(" No such status ! ");
        }
        System.out.println(" Enter by phone Number |+996 | :");
        String phoneNumber = scanner.next();
        try {
            for (Profile profile : profileList) {
                if (profile.getPhoneNumber().equals(phoneNumber)) {
                    return " This phoneNumber already exists !";
                }
                if (!(phoneNumber.startsWith("+996"))) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            return " Phone number can start +996  !";
        }
        System.out.println(" Set photo \n YES/NO");
        String y = scanner.next();
        String photo = null;
        switch (y) {
            case "yes" -> {
                System.out.println("Set photo : ");
                photo = scanner.next();
            }
            case "no" -> photo = "☺";
        }
        List<String> message = new ArrayList<>();

        whatsUpList.add(new WhatsUp(id, nickName, password, status, phoneNumber, photo, message));
        profileList.add(new Profile(id, nickName, password, status, phoneNumber, photo));
        return "Successful created !";
    }


    @Override
    public String removeWhatsUpProfile() {
        boolean isRemove = false;
        System.out.println("Enter by NIckName : ");
        String nickName = scanner.next();
        for (Profile profile : profileList) {
            if (profile.getNickName().equals(nickName)) {
                profileList.remove(profile);
                whatsUpList.remove(profile);
                isRemove = true;
                break;
            }
        }
        return isRemove ? "Successful removed !" : " Removed Failed ! ";
    }

    @Override
    public String loginWhatsapp() {
        List<Profile> profileList1 = new ArrayList<>();
        System.out.println("Enter by password : ");
        String password = scanner.next();
        for (WhatsUp whatsUp : whatsUpList) {
            if (whatsUp.getPassword().equals(password)) {
                profileList1.add(whatsUp);
                System.out.println(profileList1);
            }
        }
        return "--------------------------";
    }

    @Override
    public List<Profile> getOllProfile() {
        return this.profileList;
    }

    @Override
    public String changeStatus() {
        System.out.println("Enter by password :");
        String password = scanner.next();
        for (Profile profile : profileList) {
            if (profile.getPassword().equals(password.toLowerCase())) {
                System.out.println(profile.getStatus());
                System.out.println(Arrays.toString(Status.values()));
                System.out.println("Write new status :");
                String st = scanner.next();
                profile.setStatus(Status.valueOf(st.toUpperCase()));
                System.out.println();
                System.out.println("Status : " + profile.getStatus());
            } else {
                return "wrong password";
            }
        }
        return " Successfully changed ! ";
    }

    @Override
    public String getChat(List<Person> personList) throws Exception {
        boolean isTrue = true;
        System.out.println("Enter your nick name :");
        String nickName = new Scanner(System.in).nextLine();
        System.out.println("Enter your password :");
        String password = new Scanner(System.in).nextLine();
        for (WhatsUp whatsUp : whatsUpList) {
            if (whatsUp.getNickName().equals(nickName) && whatsUp.getPassword().equals(password)) {
                System.out.println("Who do you want to write ?");
                String contactName = new Scanner(System.in).nextLine();
                for (Person person1 : personList) {
                    for (Map.Entry<String, String> entry : person1.getContacts().entrySet()) {
                        if (entry.getValue().equals(contactName)) {
                            while (isTrue) {
                                System.out.println("Write message :");
                                String message = new Scanner(System.in).nextLine();
                                System.out.println(" Send yes/no");
                                String send = new Scanner(System.in).nextLine();
                                if (send.equals("yes")) {
                                    for (WhatsUp up : whatsUpList) {
                                        up.setMessage(Collections.singletonList(message));
                                    }
                                }else {
                                    isTrue = false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return "Successful send !";
    }

    @Override
    public List<Profile> findByProfile() {
        List<Profile> profileList1 = new ArrayList<>();
        try {
            System.out.println("Enter by name :");
            String nickName = scanner.next();
            for (Profile profile : this.profileList) {
                if (profile.getNickName().equals(nickName)) {
                    profileList1.add(profile);
                }
            }
            if (profileList1.isEmpty()) throw new Exception();
        } catch (Exception e) {
            System.out.println("There is no such profile ! ");
        }
        return profileList1;
    }
}
