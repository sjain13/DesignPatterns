package StructuralPatterns.BridgePattern;

public class BridgePattern {

	public static void main(String[] args) {
		Transmission manual = new ManualTransmission();
		Vehicle car = new Car(manual);
		car.applyTransmission();

	}

}
