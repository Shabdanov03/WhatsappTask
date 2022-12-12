package classes;

import enums.Status;

public class Profile {
    private int id;
    private String nickName;
    private String password;
    private Status status;
    private String phoneNumber;
    private String photo;

    public Profile() {

    }

    public Profile(int id, String nickName, String password, Status status, String phoneNumber, String photo) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return " \n  Profile :" +
                "\n id :" + id+
                "\n nickName :" + nickName +
                "\n password :" + password +
                "\n status :" + status +
                "\n phoneNumber :" + phoneNumber+
                "\n photo :" + photo +
                "\n====================";
    }
}
