public class Rectangle extends Shape {
    private double width, height;

    // change the rectangle's width.
    public void setWidth(double width) {
        this.width = width;
    }

    // change the rectangle's height.
    public void setHeight(double height) {
        this.height = height;
    }

    // get the area of the rectangle given width and height.
    public double getArea() {
        return this.width * this.height;
    }

    // get the perimeter of the square given the side.
    public double getPerimeter() {
        return (2 * this.width) + (2 * this.height);
    }
}
