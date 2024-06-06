package BehavioralPattern.visitor;

public class Electronics implements Product {

	@Override
	public void accept(DiscountVisitor visitor) {
		visitor.visitElectronics(this);

	}

}
