package classes;

import enums.Status;

import java.util.List;

public class WhatsUp extends Profile {
   private List<String> message ;

   public WhatsUp () {

   }
    public WhatsUp(int id, String nickName, String password, Status status, String phoneNumber, String photo, List<String> message) {
        super(id, nickName, password, status, phoneNumber, photo);
        this.message = message;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "\n  WhatsUp : \n" + super.toString()+
                "\nmessage : " + message +
                "\n=========================";
    }
}
