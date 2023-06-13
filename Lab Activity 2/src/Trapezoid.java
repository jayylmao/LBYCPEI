public class Trapezoid extends Shape {
    private double topBase, bottomBase, height;

    // methods that set the individual side lengths of the trapezoid.
    public void setTopBase(double topBase) {
        this.topBase = topBase;
    }

    public void setBottomBase(double bottomBase) {
        this.bottomBase = bottomBase;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // get the area of the trapezoid given the side lengths.
    public double getArea() {
        return (topBase + bottomBase) * (height / 2);
    }

    // get the perimeter of the trapezoid given the side lengths.
    public double getPerimeter() {
        return topBase + bottomBase + (2 * height);
    }
}
