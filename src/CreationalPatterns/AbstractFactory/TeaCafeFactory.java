package CreationalPatterns.AbstractFactory;

public class TeaCafeFactory implements CafeFactory {

	 public Drink createDrink() {
	        return new TeaDrink();
	    }

	    public Pastry createPastry() {
	        return new TeaPastry();
	    }

}
