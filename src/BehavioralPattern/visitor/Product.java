package BehavioralPattern.visitor;

public interface Product {
	void accept(DiscountVisitor visitor);

}
