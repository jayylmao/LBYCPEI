public class Square extends Shape {
    private double side;

    // change the length of the square's side.
    public void setSide(double side) {
        this.side = side;
    }

    // get the area of the square given the side.
    public double getArea() {
        return this.side * this.side;
    }

    // get the perimeter of the square given the side.
    public double getPerimeter() {
        return 4 * this.side;
    }
}
