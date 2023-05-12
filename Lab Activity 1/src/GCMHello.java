import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class GCMHello extends GraphicsProgram {
    public void run() {
        GLabel hello = new GLabel("Hello, LBYCPEI world!");
        add(hello, 100, 100);
    }

    public static void main (String[] args) {
        (new GCMHello()).start(args);
    }
}