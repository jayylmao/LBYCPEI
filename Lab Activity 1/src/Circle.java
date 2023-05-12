public class Circle {
    private int radius = 4;

    double GetArea() {
        return 3.14 * radius * radius;
    }

    double GetPerimeter() {
        return 2 * 3.14 * radius;
    }

    public static void main(String[] args) {
        Circle myCircle = new Circle();

        System.out.println("area of the circle is: " + myCircle.GetArea());
    }
}