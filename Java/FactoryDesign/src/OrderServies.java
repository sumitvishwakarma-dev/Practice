import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderServies {

    public void sendNotification(){
      List<Notification> notification =  NotificationFactory.sendNotification(new ArrayList<>(
              Arrays.asList("EMAIL")
      ));
        System.out.println("Order Service");
        for (Notification notificationType : notification ){
          notificationType.send();
      }
    }

}
