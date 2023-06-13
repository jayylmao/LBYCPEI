public class Ellipse extends Shape {
    private double semiMajorAxis, semiMinorAxis;

    // set the semi major axis.
    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    // set the semi minor axis.
    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }

    // get the area of the ellipse given the semi major and minor axes.
    public double getArea() {
        return Math.PI * semiMinorAxis * semiMajorAxis;
    }

    // get the perimeter of the ellipse given the semi major and minor axes.
    public double getPerimeter() {
        return (2 * Math.PI) * Math.sqrt((Math.pow(semiMajorAxis, 2) + Math.pow(semiMinorAxis, 2)) / 2);
    }
}
