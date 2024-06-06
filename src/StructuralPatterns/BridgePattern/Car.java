package StructuralPatterns.BridgePattern;

public class Car extends Vehicle {

	public Car(Transmission transmission) {
		super(transmission);
	}

	@Override
	void applyTransmission() {
		transmission.applyGear();
		
	}

}
