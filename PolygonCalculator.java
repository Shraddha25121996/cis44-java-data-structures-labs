/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author shraddhapatel
 */
public class PolygonCalculator {
    public static void main(String[] args) {
        
    }
}
// Step 1: Polygon interface
interface Polygon {
    double area();
    double perimeter();
}

// Step 2: Quadrilateral base class
class Quadrilateral implements Polygon {
    @Override
    public double area() { return 0; }
    @Override
    public double perimeter() { return 0; }
}

// Step 3: Rectangle
class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() { return length * width; }

    @Override
    public double perimeter() { return 2 * (length + width); }
}

// Step 4: Square
class Square extends Rectangle {
    public Square(double side) { super(side, side); }
}

// Step 5: Triangle
class Triangle implements Polygon {
    protected double base, height, side1, side2, side3;

    public Triangle(double side1, double side2, double side3, double height) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = height;
        this.base = side1;
    }

    @Override
    public double area() { return 0.5 * base * height; }

    @Override
    public double perimeter() { return side1 + side2 + side3; }
}

// Step 6: Pentagon
class Pentagon implements Polygon {
    private double side;
    public Pentagon(double side) { this.side = side; }
    @Override
    public double area() { return (Math.sqrt(5*(5+2*Math.sqrt(5))) * side*side)/4; }
    @Override
    public double perimeter() { return 5 * side; }
}

// Step 7: Hexagon
class Hexagon implements Polygon {
    private double side;
    public Hexagon(double side) { this.side = side; }
    @Override
    public double area() { return ((3*Math.sqrt(3))/2) * side*side; }
    @Override
    public double perimeter() { return 6 * side; }
}

// Step 8: Octagon
class Octagon implements Polygon {
    private double side;
    public Octagon(double side) { this.side = side; }
    @Override
    public double area() { return 2*(1+Math.sqrt(2))*side*side; }
    @Override
    public double perimeter() { return 8 * side; }
}

// Step 9: Main class with main method
public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Polygon Calculator Demo!\n-----------------------");

        Rectangle rect = new Rectangle(5,3);
        System.out.println("Rectangle: Area = " + rect.area() + ", Perimeter = " + rect.perimeter());

        Square sq = new Square(4);
        System.out.println("Square: Area = " + sq.area() + ", Perimeter = " + sq.perimeter());

        Triangle tri = new Triangle(3,4,5,2.5);
        System.out.println("Triangle: Area = " + tri.area() + ", Perimeter = " + tri.perimeter());

        Pentagon pent = new Pentagon(3);
        System.out.println("Pentagon: Area = " + pent.area() + ", Perimeter = " + pent.perimeter());

        Hexagon hex = new Hexagon(2);
        System.out.println("Hexagon: Area = " + hex.area() + ", Perimeter = " + hex.perimeter());

        Octagon oct = new Octagon(1.5);
        System.out.println("Octagon: Area = " + oct.area() + ", Perimeter = " + oct.perimeter());

        scanner.close();
    }
}

