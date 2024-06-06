package BehavioralPattern.visitor;

public class Food implements Product {

	@Override
	public void accept(DiscountVisitor visitor) {
		visitor.visitFood(this);

	}

}
