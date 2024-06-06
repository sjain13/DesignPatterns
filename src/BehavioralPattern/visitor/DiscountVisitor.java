package BehavioralPattern.visitor;

public interface DiscountVisitor {
	void visitFood(Food food);
    void visitClothing(Clothing clothing);
    void visitElectronics(Electronics electronics);

}
