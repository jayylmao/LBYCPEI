import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class PhilippineFlag extends GraphicsProgram {
    public void run() {
        // the top, blue half of the flag
        GPolygon blueFlag = new GPolygon(0, 0);
        blueFlag.setFilled(true);
        blueFlag.setFillColor(Color.blue);
        blueFlag.setLineWidth(0);
        blueFlag.addVertex(0, 0);
        blueFlag.addVertex(800, 0);
        blueFlag.addVertex(800, 200);
        blueFlag.addVertex(300, 200);

        // the bottom, red half of the flag
        GPolygon redFlag = new GPolygon(0, 0);
        redFlag.setFilled(true);
        redFlag.setFillColor(Color.red);
        redFlag.setLineWidth(0);
        redFlag.addVertex(300, 200);
        redFlag.addVertex(800, 200);
        redFlag.addVertex(800, 400);
        redFlag.addVertex(0, 400);

        // the sun's body
        GOval sunBody = new GOval(50, 150, 100, 100);
        sunBody.setFilled(true);
        sunBody.setFillColor(Color.yellow);
        sunBody.setLineWidth(0);

        // the sun's rays
        for (int angle = 0; angle < 360; angle += 45) {
            // main part of the ray
            GPolygon ray = new GPolygon();
            ray.setFilled(true);
            ray.setFillColor(Color.yellow);
            ray.setLineWidth(0);
            ray.setCenterLocation(100, 200);
            ray.addVertex(-5, 50);
            ray.addVertex(-5, 80);
            ray.addVertex(0, 90);
            ray.addVertex(5, 80);
            ray.addVertex(5, 50);
            add(ray);
            ray.rotate(angle);

            // left side of the ray
            GPolygon rayLeftSide = new GPolygon();
            rayLeftSide.setFilled(true);
            rayLeftSide.setFillColor(Color.yellow);
            rayLeftSide.setLineWidth(0);
            rayLeftSide.setCenterLocation(100, 200);
            rayLeftSide.addVertex(-15, 40);
            rayLeftSide.addVertex(-10, 45);
            rayLeftSide.addVertex(-10, 75);
            rayLeftSide.addVertex(-15, 70);
            add(rayLeftSide);
            rayLeftSide.rotate(angle);

            // right side of the ray
            GPolygon rayRightSide = new GPolygon();
            rayRightSide.setFilled(true);
            rayRightSide.setFillColor(Color.yellow);
            rayRightSide.setLineWidth(0);
            rayRightSide.setCenterLocation(100, 200);
            rayRightSide.addVertex(15, 40);
            rayRightSide.addVertex(10, 45);
            rayRightSide.addVertex(10, 75);
            rayRightSide.addVertex(15, 70);
            add(rayRightSide);
            rayRightSide.rotate(angle);
        }

        // the three stars
        int starXCoordinates[] = {30, 250, 30};
        int starYCoordinates[] = {50, 207, 370};
        int starRotation[] = {30, -15, 15};

        for (int i = 0; i < 3; i++) {
            GStar star = new GStar(20);
            star.setCenterLocation(starXCoordinates[i], starYCoordinates[i]);
            star.setFillColor(Color.yellow);
            star.setFilled(true);
            star.setLineWidth(0);

            star.rotate(starRotation[i]);
            add(star);
        }

        add(blueFlag);
        add(redFlag);
        add(sunBody);
    }

    public static void main(String[] args) {
        (new PhilippineFlag()).start(args);
    }
}
