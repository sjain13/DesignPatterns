package StructuralPatterns.BridgePattern;

public abstract class Vehicle {
	protected Transmission transmission;
	

	public Vehicle(Transmission transmission) {
		this.transmission = transmission;
	}

	abstract void applyTransmission();

}
