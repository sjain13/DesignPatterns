package BehavioralPattern.visitor;

public class ClearanceDiscountVisitor implements DiscountVisitor {

	@Override
	public void visitFood(Food food) {
		System.out.println("Applying clearance discount to food.");

	}

	@Override
	public void visitClothing(Clothing clothing) {
		System.out.println("Applying clearance discount to clothing.");

	}

	@Override
	public void visitElectronics(Electronics electronics) {
		System.out.println("Applying clearance discount to electronics.");

	}

}
