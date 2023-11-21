import adapter.PizzaAdapter;
import decorator.CheeseDecorator;
import decorator.Pizza;
import factory.PizzaFactory;
import observer.DeliveryService;
import singleton.PizzaShop;
import strategy.CashPayment;
import strategy.CreditCardPayment;
import strategy.PaymentStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Main class
public class PizzaOrderingSystem {
    public static void main(String[] args) {
        PizzaShop pizzaShop = PizzaShop.getInstance();
        PizzaFactory pizzaFactory = new PizzaFactory();
        PizzaAdapter pizzaAdapter = new PizzaAdapter();
        DeliveryService deliveryService = new DeliveryService();

        // Observer pattern
        pizzaShop.addObserver(deliveryService);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the decorator.Pizza Ordering System!");

        // User interface...
        System.out.println("Enter pizza type (e.g., Margherita): ");
        String pizzaType = scanner.nextLine();

        // Factory pattern
        Pizza pizza = pizzaFactory.createPizza(pizzaType);

        // Decorator pattern
        System.out.println("Do you want extra cheese? (y/n): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            pizza = new CheeseDecorator(pizza);
        }

        // Adapter pattern
        System.out.println("Select payment method (credit/cash): ");
        String paymentMethod = scanner.nextLine();
        PaymentStrategy paymentStrategy;
        switch (paymentMethod.toLowerCase()) {
            case "credit":
                paymentStrategy = new CreditCardPayment();
                break;
            case "cash":
                paymentStrategy = new CashPayment();
                break;
            default:
                throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
        }

        // Observer pattern
        pizzaShop.notifyObservers("decorator.Pizza ordered: " + pizza.getDescription());

        // Adapter pattern
        pizzaAdapter.orderPizza(pizza, paymentStrategy);

        scanner.close();
    }
}


