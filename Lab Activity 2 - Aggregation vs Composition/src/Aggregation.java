import acm.graphics.*;
import acm.program.*;
import java.awt.*;
public class Aggregation extends GraphicsProgram {
    public void run() {
        // aggregation
        setTitleText(190, 100, "Aggregation");

        // container of parent class.
        GRect aggregationParent = new GRect(200, 120, 100, 50);
        aggregationParent.setFilled(true);
        aggregationParent.setFillColor(Color.decode("#fffaf3"));
        add(aggregationParent);

        // "House" label representing the parent class of an aggregation relationship.
        GLabel aggregationParentLabel = new GLabel("House", 235, 150);
        aggregationParentLabel.setColor(Color.decode("#907aa9"));
        add(aggregationParentLabel);

        // container of child classes.
        int[] aggregationChildXCoordinates = {50, 200, 350};

        // programmatically add 3 children to the aggregation parents.
        for (int i = 0; i < 3; i++) {
            GRect aggregationChild = new GRect(aggregationChildXCoordinates[i], 250, 100, 50);
            aggregationChild.setFilled(true);
            aggregationChild.setFillColor(Color.decode("#faf4ed"));

            add(aggregationChild);
            GLabel aggregationChildLabel = new GLabel("Family member " + (i + 1), aggregationChildXCoordinates[i] + 5, 280);
            aggregationChildLabel.setColor(Color.decode("#797593"));
            add(aggregationChildLabel);

            GLine aggregationChildConnector = new GLine(aggregationChildXCoordinates[i] + 50, 250, 250, 170);
            add(aggregationChildConnector);
        }


        // THE ACTUAL AGGREGATION IMAGE


        GPolygon roof = new GPolygon();
        roof.addVertex(700, 200);
        roof.addVertex(850, 125);
        roof.addVertex(1000, 200);
        roof.setFilled(true);
        roof.setFillColor(Color.decode("#b4637a"));
        add(roof);

        GRect houseBody = new GRect(725, 200, 255, 150);
        add(houseBody);

        person(750, 280, 1, "1");
        person(950, 280, 1, "2");
        person(1050, 280, 1, "3");

        // explanation for the image.
        GLabel aggregationImageExplanation = new GLabel("The family members belong to a house, but can exist independently of it, such as in the case of member 3.",
        600, 420);
        aggregationImageExplanation.setColor(Color.decode("#575279"));
        add(aggregationImageExplanation);
 }
        public void person(int xPosition, int yPosition, float scale, String label) {
            // color to be used for person
            Color personColor = Color.decode("#191724");

            // note that all positions are relative to xPosition and yPosition, and all measurements are relative to the scale factor.

            // constructs the head
            GOval head = new GOval(20 * scale, 20 * scale);
            head.setCenterLocation(xPosition, yPosition);
            head.setFilled(true);
            head.setFillColor(personColor);
            add(head);

            // constructs the label placed above the person's head.
            GLabel personLabel = new GLabel(label);
            personLabel.setCenterLocation(xPosition, (yPosition - 30) * scale);
            personLabel.setFont("Arial-Bold-16");
            personLabel.setColor(Color.decode("#286983"));
            add(personLabel);

            // constructs the main body.
            GRect body = new GRect(xPosition - (7 * scale), yPosition + (12 * scale), 15 * scale, 30 * scale);
            body.setFilled(true);
            body.setFillColor(personColor);
            add(body);

            // constructs each limb of the body.
            GRect leftLeg = new GRect(xPosition - (7 * scale), yPosition + (44 * scale), 6 * scale, 25 * scale);
            leftLeg.setFilled(true);
            leftLeg.setFillColor(personColor);
            add(leftLeg);

            GRect rightLeg = new GRect(xPosition + (2 * scale), yPosition + (44 * scale), 6 * scale, 25 * scale);
            rightLeg.setFilled(true);
            rightLeg.setFillColor(personColor);
            add(rightLeg);

            GRect leftArm = new GRect(xPosition - (15 * scale), yPosition + (12 * scale), 6 * scale, 25 * scale);
            leftArm.setFilled(true);
            leftArm.setFillColor(personColor);
            add(leftArm);

            GRect rightArm = new GRect(xPosition + (10 * scale), yPosition + (12 * scale), 6 * scale, 25 * scale);
            rightArm.setFilled(true);
            rightArm.setFillColor(personColor);
            add(rightArm);
        }
        public void setTitleText(int xPosition, int yPosition, String labelText) {
            GLabel label = new GLabel(labelText, xPosition, yPosition);
            label.setFont("Verdana-Bold-24");
            label.setColor(Color.decode("#575279"));
            add(label);
        }
        public static void main(String[] args) {
            (new Aggregation()).start(args);
        }
    }