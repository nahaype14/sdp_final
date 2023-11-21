package observer;

public class DeliveryService implements OrderObserver {
    @Override
    public void update(String message) {
        System.out.println("Delivery service received order: " + message);
        // Logic for delivery processing...
    }
}
