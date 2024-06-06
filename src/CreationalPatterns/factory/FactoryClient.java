package CreationalPatterns.factory;

public class FactoryClient {
	public static void main(String[] args) {
        Shape hexagon = ShapeFactory.getShape("Hexagon");
        hexagon.draw();

        Shape pentagon = ShapeFactory.getShape("Pentagon");
        pentagon.draw();
    }

}
