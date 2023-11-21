package factory;

import decorator.MargheritaPizza;
import decorator.Pizza;

// Factory pattern
public class PizzaFactory {
    public Pizza createPizza(String type) {
        switch (type.toLowerCase()) {
            case "margherita":
                return new MargheritaPizza();
            default:
                throw new IllegalArgumentException("Invalid pizza type: " + type);
        }
    }
}
