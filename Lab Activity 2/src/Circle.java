public class Circle extends Shape {
    private double radius;

    // change the circle's radius.
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // get the area of the circle given radius.
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    // get the perimeter of the circle given radius.
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }
}
