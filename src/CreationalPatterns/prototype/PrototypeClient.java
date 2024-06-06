package CreationalPatterns.prototype;

public class PrototypeClient {

	public static void main(String[] args) {
		Car basicCar = new BasicCar();
        Car customerCar = (Car) basicCar.clone();
        
        customerCar.customize("Red", "Sunroof");

	}

}
