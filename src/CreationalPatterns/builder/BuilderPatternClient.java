package CreationalPatterns.builder;

public class BuilderPatternClient {

	public static void main(String[] args) {
		 Waiter waiter = new Waiter();
	     PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
	     waiter.setPizzaBuilder(hawaiianPizzaBuilder);
	     waiter.constructPizza();

	     Pizza pizza = waiter.getPizza();
	     pizza.showPizza();

	        

	}

}
