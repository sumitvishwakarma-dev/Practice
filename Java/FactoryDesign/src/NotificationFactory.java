import java.util.ArrayList;
import java.util.List;

public class NotificationFactory {

    static Notification sendNotification(String type){
        if (type.equals("SMS")){
            return new SMSNotification();
        }else if (type.equals("EMAIL")){
            return new EmailNotification();
        }
        return null;
    }


    static List<Notification> sendNotification(List<String> types){

        List<Notification> list = new ArrayList();
        for (String type : types){
            if (type.equals("SMS")){
                list.add(new SMSNotification());
            }else
                if(type.equals("EMAIL")){
                    list.add(new EmailNotification());
                }
        }
        return list;
    }

}
