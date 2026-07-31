
public class Main {

    public static void main(String[] args) {
        OrderServies orderServies = new OrderServies();
        orderServies.sendNotification();

        DeliveryService deliveryService = new DeliveryService();
        deliveryService.sendNotification();
    }
}