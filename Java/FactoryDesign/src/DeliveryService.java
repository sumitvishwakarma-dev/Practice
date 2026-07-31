import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryService {

    void sendNotification(){
        List<Notification> notification = NotificationFactory
                .sendNotification(new ArrayList<>(
                        Arrays.asList("EMAIL","SMS")
                ));
        System.out.println("Delivery Service");
        for (Notification notificationString : notification){
            notificationString.send();
        }

    }

}
