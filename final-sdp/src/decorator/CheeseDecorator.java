package decorator;

public class CheeseDecorator extends ToppingDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
        description = "Extra Cheese";
    }

    @Override
    public double cost() {
        return pizza.cost() + 2.00;
    }
}
