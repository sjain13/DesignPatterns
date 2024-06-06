package BehavioralPattern.visitor;

public class Clothing implements Product {

	@Override
	public void accept(DiscountVisitor visitor) {
		visitor.visitClothing(this);

	}

}
