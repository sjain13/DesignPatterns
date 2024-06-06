package CreationalPatterns.AbstractFactory;

public class AbstractFactoryClient {
	public static void main(String[] args) {
        CafeFactory coffeeFactory = new CoffeeCafeFactory();
        Drink coffee = coffeeFactory.createDrink();
        Pastry croissant = coffeeFactory.createPastry();

        coffee.serve();
        croissant.serve();
        CafeFactory teaFactory = new TeaCafeFactory();
        Drink tea = teaFactory.createDrink();
        Pastry scone = teaFactory.createPastry();

        tea.serve();
        scone.serve();
    }

}
