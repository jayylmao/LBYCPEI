import org.w3c.dom.css.Rect;

import java.util.Scanner;
public class ShapeCalculator {
    // Scanner object is used for user input
    // Documentation: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Creating a Menu
        int choice = 0;
        while (true) {
            System.out.println("\n============== MAIN MENU ===============" +
                                "\n     1. Square Computations " +
                                "\n     2. Rectangle Computations" +
                                "\n     3. Circle Computations" +
                                "\n     4. Ellipse Computations" +
                                "\n     5. Trapezoid Computations" +
                                "\n     6. Parallelogram Computations" +
                                "\n     7. Exit");
            System.out.print("\n>> ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n 1. Square Computations ");
                    squareComputations();
                    break;
                case 2:
                    System.out.println("\n 2. Rectangle Computations");
                    rectangleComputations();
                    break;
                case 3:
                    System.out.println("\n 3. Circle Computations");
                    circleComputations();
                    break;
                case 4:
                    System.out.println("\n 4. Ellipse Computations");
                    ellipseComputations();
                    break;
                case 5:
                    System.out.println("\n 5. Trapezoid Computations");
                    trapezoidComputations();
                    break;
                case 6:
                    System.out.println("\n 6. Parallelogram Computations");
                    parallelogramComputations();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("INVALID INPUT!!!!");
            }
            if (choice == 7) {
                System.out.println("Exiting Now!!!");
                break;
            }
        }
    }

    // all operations involving a square.
    private static void squareComputations() {
        Square square = new Square();
        System.out.print("Input the side of the square: ");
        double side = scanner.nextDouble();
        square.setSide(side);

        System.out.println("\nThe area is " + square.getArea() + " sq. units.");
        System.out.println("\nThe perimeter is " + square.getPerimeter() + " units.");
    }

    private static void rectangleComputations() {
        Rectangle rectangle = new Rectangle();
        System.out.print("Input the width of the rectangle: ");
        double width = scanner.nextDouble();
        rectangle.setWidth(width);

        System.out.print("\nInput the height of the rectangle: ");
        double height = scanner.nextDouble();
        rectangle.setHeight(height);

        System.out.println("\nThe area is " + rectangle.getArea() + " sq. units.");
        System.out.println("\nThe perimeter is " + rectangle.getPerimeter() + " units.");
    }

    private static void circleComputations() {
        Circle circle = new Circle();
        System.out.print("Input the radius of the circle: ");
        double radius = scanner.nextDouble();
        circle.setRadius(radius);

        System.out.println("\nThe area is " + circle.getArea() + " sq. units.");
        System.out.println("\nThe perimeter is " + circle.getPerimeter() + " units.");
    }

    private static void ellipseComputations() {
        Ellipse ellipse = new Ellipse();
        System.out.print("Input the length of the major axis: ");
        double semiMajorAxis = scanner.nextDouble();
        ellipse.setSemiMajorAxis(semiMajorAxis);

        System.out.print("\nInput the length of the major axis: ");
        double semiMinorAxis = scanner.nextDouble();
        ellipse.setSemiMinorAxis(semiMinorAxis);

        System.out.println("\nThe area is " + ellipse.getArea() + " sq. units.");
        System.out.println("\nThe perimeter is " + ellipse.getPerimeter() + " units.");
    }

    private static void trapezoidComputations() {
        Trapezoid trapezoid = new Trapezoid();
        System.out.print("Input the length of base A: ");
        double topBase = scanner.nextDouble();
        trapezoid.setTopBase(topBase);

        System.out.println("\nInput the length of base B: ");
        double bottomBase = scanner.nextDouble();
        trapezoid.setBottomBase(bottomBase);

        System.out.println("\nInput the height of the trapezoid: ");
        double height = scanner.nextDouble();
        trapezoid.setHeight(height);

        System.out.println("\nThe area is " + trapezoid.getArea() + " sq. units.");
        System.out.println("\nThe perimeter is " + trapezoid.getPerimeter() + " units.");
    }

    private static void parallelogramComputations() {
        Parallelogram parallelogram = new Parallelogram();
        System.out.println("Input the length of the base: ");
        double base = scanner.nextDouble();
        parallelogram.setBase(base);

        System.out.println("\nInput the height of the parallelogram: ");
        double height = scanner.nextDouble();
        parallelogram.setHeight(height);

        System.out.println("\nInput the length of a side adjacent to the base: ");
        double sideLength = scanner.nextDouble();
        parallelogram.setSideLength(sideLength);

        System.out.println("\nThe area is " + parallelogram.getArea() + " sq. units.");
        System.out.println("\nThe perimeter is " + parallelogram.getPerimeter() + " units.");
    }
}