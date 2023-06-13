import acm.graphics.GLabel;
import acm.program.*;
import java.awt.*;

public class FancyHelloWorld extends GraphicsProgram {
    public void run() {
        GLabel text = new GLabel("Hello LBYCPEI OOP!");
        text.setFont("Segoe UI Variable Medium-48");
        text.setColor(Color.blue);
        double x = (getWidth() - text.getWidth()) / 2;
        double y = (getHeight() + text.getAscent()) / 2;
        add(text, x, y);
    }
    public static void main(String[] args) {
        (new FancyHelloWorld()).start(args);
    }
}