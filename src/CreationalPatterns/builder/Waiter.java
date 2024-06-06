package CreationalPatterns.builder;

//Director class to construct the pizza
public class Waiter {
	private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildSize();
        pizzaBuilder.buildCrust();
        pizzaBuilder.buildToppings();
    }

}
