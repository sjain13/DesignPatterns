package StructuralPatterns.Flyweight;

public class FlyweightPatternClent {

    public static void main(String[] args) {
        Circle redCircle1 = CircleFactory.getCircle("Red");
        redCircle1.draw(10, 20, 5);

        Circle blueCircle1 = CircleFactory.getCircle("Blue");
        blueCircle1.draw(15, 25, 10);

        Circle redCircle2 = CircleFactory.getCircle("Red"); // Reuse Red circle
        redCircle2.draw(30, 40, 15);

        Circle greenCircle = CircleFactory.getCircle("Green");
        greenCircle.draw(50, 60, 20);

        Circle blueCircle2 = CircleFactory.getCircle("Blue"); // Reuse Blue circle
        blueCircle2.draw(70, 80, 25);
    }
    
}
