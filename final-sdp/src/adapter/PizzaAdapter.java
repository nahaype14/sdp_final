package adapter;

import decorator.Pizza;
import strategy.PaymentStrategy;

// Adapter pattern
public class PizzaAdapter {
    public void orderPizza(Pizza pizza, PaymentStrategy paymentStrategy) {
        System.out.println("Order received: " + pizza.getDescription());
        paymentStrategy.pay(pizza.cost());
    }
}
