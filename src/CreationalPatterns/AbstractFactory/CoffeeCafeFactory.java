package CreationalPatterns.AbstractFactory;

public class CoffeeCafeFactory implements CafeFactory {

	@Override
	public Drink createDrink() {
		 return new CoffeeDrink();
	}

	@Override
	public Pastry createPastry() {
		return new CoffeePastry();
	}

}
