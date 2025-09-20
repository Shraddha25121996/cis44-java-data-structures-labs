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
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Polygon Calculator ---");
            System.out.println("1) Triangle (any)");
            System.out.println("2) Isosceles Triangle");
            System.out.println("3) Equilateral Triangle");
            System.out.println("4) Rectangle");
            System.out.println("5) Square");
            System.out.println("6) Pentagon (regular)");
            System.out.println("7) Hexagon (regular)");
            System.out.println("8) Octagon (regular)");
            System.out.println("9) Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number 1-9.");
                continue;
            }

            if (choice == 9) {
                System.out.println("Goodbye!");
                break;
            }

            Polygon poly = null;
            try {
                switch (choice) {
                    case 1 -> { // Triangle
                        System.out.print("Enter side a: ");
                        double a = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter side b: ");
                        double b = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter side c: ");
                        double c = Double.parseDouble(sc.nextLine());
                        if (!Triangle.isValidTriangle(a, b, c)) {
                            System.out.println("Invalid triangle sides. They must satisfy triangle inequality and be > 0.");
                            continue;
                        }
                        poly = new Triangle(a, b, c);
                    }
                    case 2 -> { // Isosceles
                        System.out.print("Enter equal side length: ");
                        double equal = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter base length: ");
                        double base = Double.parseDouble(sc.nextLine());
                        if (!Triangle.isValidTriangle(equal, equal, base)) {
                            System.out.println("Invalid isosceles triangle dimensions.");
                            continue;
                        }
                        poly = new IsoscelesTriangle(equal, base);
                    }
                    case 3 -> { // Equilateral
                        System.out.print("Enter side length: ");
                        double s = Double.parseDouble(sc.nextLine());
                        if (s <= 0) { System.out.println("Side must be > 0."); continue; }
                        poly = new EquilateralTriangle(s);
                    }
                    case 4 -> { // Rectangle
                        System.out.print("Enter length: ");
                        double length = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter width: ");
                        double width = Double.parseDouble(sc.nextLine());
                        if (length <= 0 || width <= 0) { System.out.println("Dimensions must be > 0."); continue; }
                        poly = new Rectangle(length, width);
                    }
                    case 5 -> { // Square
                        System.out.print("Enter side length: ");
                        double side = Double.parseDouble(sc.nextLine());
                        if (side <= 0) { System.out.println("Side must be > 0."); continue; }
                        poly = new Square(side);
                    }
                    case 6 -> { // Pentagon (regular)
                        System.out.print("Enter side length: ");
                        double side = Double.parseDouble(sc.nextLine());
                        if (side <= 0) { System.out.println("Side must be > 0."); continue; }
                        poly = new RegularPolygon(5, side);
                    }
                    case 7 -> {
                        System.out.print("Enter side length: ");
                        double side = Double.parseDouble(sc.nextLine());
                        if (side <= 0) { System.out.println("Side must be > 0."); continue; }
                        poly = new RegularPolygon(6, side);
                    }
                    case 8 -> {
                        System.out.print("Enter side length: ");
                        double side = Double.parseDouble(sc.nextLine());
                        if (side <= 0) { System.out.println("Side must be > 0."); continue; }
                        poly = new RegularPolygon(8, side);
                    }
                    default -> {
                        System.out.println("Please choose a valid option (1-9).");
                        continue;
                    }
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid numeric input. Try again.");
                continue;
            }

            if (poly != null) {
                double area = poly.area();
                double perim = poly.perimeter();
                System.out.printf("Perimeter: %.4f\n", perim);
                System.out.printf("Area: %.4f\n", area);
            }
        }

        sc.close();
    }
}

/* -------------------------
   Below: interface and shape classes (non-public)
   They are in the same file so you only run one file.
   ------------------------- */

interface Polygon {
    double area();
    double perimeter();
}

class Triangle implements Polygon {
    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static boolean isValidTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        double s = perimeter() / 2.0;
        double val = s * (s - a) * (s - b) * (s - c);
        if (val <= 0) return 0.0;
        return Math.sqrt(val);
    }
}

class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
    }
}

class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side, side, side);
    }

    @Override
    public double area() {
        // exact formula for equilateral triangle
        return (Math.sqrt(3) / 4.0) * a * a;
    }
}

class Quadrilateral implements Polygon {
    protected double a, b, c, d;

    public Quadrilateral(double a, double b, double c, double d) {
        this.a = a; this.b = b; this.c = c; this.d = d;
    }

    @Override
    public double perimeter() {
        return a + b + c + d;
    }

    @Override
    public double area() {
        // Generic quadrilateral: area depends on angles too.
        // Return 0 as placeholder; subclasses override when possible.
        return 0;
    }
}

class Rectangle extends Quadrilateral {
    protected double length, width;

    public Rectangle(double length, double width) {
        super(length, width, length, width);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() { return length * width; }

    @Override
    public double perimeter() { return 2 * (length + width); }
}

class Square extends Rectangle {
    public Square(double side) { super(side, side); }
}

/** Regular polygon (n sides, equal length). */
class RegularPolygon implements Polygon {
    private final int n;
    private final double s;

    public RegularPolygon(int n, double side) {
        if (n < 3) throw new IllegalArgumentException("n must be >= 3");
        this.n = n;
        this.s = side;
    }

    @Override
    public double perimeter() {
        return n * s;
    }

    @Override
    public double area() {
        // Area = (n * s^2) / (4 * tan(pi/n))
        return (n * s * s) / (4.0 * Math.tan(Math.PI / n));
    }

}
