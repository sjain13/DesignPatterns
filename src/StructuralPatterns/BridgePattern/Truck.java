package StructuralPatterns.BridgePattern;

public class Truck extends Vehicle {

	public Truck(Transmission transmission) {
		super(transmission);
	}

	@Override
	void applyTransmission() {
		transmission.applyGear();
		
	}

}
