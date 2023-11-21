package decorator;

public class MargheritaPizza extends Pizza {
    public MargheritaPizza() {
        description = "Margherita decorator.Pizza";
    }

    @Override
    public double cost() {
        return 8.99;
    }
}
