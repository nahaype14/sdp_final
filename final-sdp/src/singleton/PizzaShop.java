package singleton;
import observer.OrderObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Singleton pattern
public class PizzaShop {
    private static PizzaShop instance;

    private PizzaShop() {
    }

    public static PizzaShop getInstance() {
        if (instance == null) {
            instance = new PizzaShop();
        }
        return instance;
    }

    // Observer pattern
    private List<OrderObserver> observers = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (OrderObserver observer : observers) {
            observer.update(message);
        }
    }

    // Other pizza shop methods...
}
