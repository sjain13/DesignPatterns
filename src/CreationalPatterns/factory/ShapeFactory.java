package CreationalPatterns.factory;

//Factory class
public class ShapeFactory {
	static Shape getShape(String type) {
        if ("Hexagon".equalsIgnoreCase(type)) {
            return new Hexagon();
        } else if ("Pentagon".equalsIgnoreCase(type)) {
            return new Pentagon();
        }
        return null;
    }

}
