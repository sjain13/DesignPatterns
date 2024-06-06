package CreationalPatterns.builder;

public abstract class PizzaBuilder {
	public abstract void buildSize();
    public abstract void buildCrust();
    public abstract void buildToppings();
	protected Pizza pizza;
	
	public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza("default", "default", "default");
    }  

}
