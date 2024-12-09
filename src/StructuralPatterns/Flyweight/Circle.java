package StructuralPatterns.Flyweight;

public class Circle {
    private String color; // Intrinsic state (shared)

    public Circle(String color) {
        this.color = color;
    }

    public void draw(int x, int y, int radius) {
        // Extrinsic state (unique)
        System.out.println("Drawing " + color + " circle at (" + x + ", " + y + ") with radius " + radius);
    }
}
