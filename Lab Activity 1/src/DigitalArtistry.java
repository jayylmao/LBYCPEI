import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class DigitalArtistry extends GraphicsProgram {
    public void run() {
        GImage image = new GImage("cover5.jpg");
        add(image, 0, 0);

        GLabel trump = new GLabel("It's joever!!!");
        GLabel blast = new GLabel("BIDEN BLAST!!!");
        trump.setFont("Bodoni MT-Bold-100");
        trump.setColor(Color.RED);
        blast.setColor(Color.RED);
        blast.setFont("Baskerville Old Face-Bold-100");

        add(trump, 300, 100);
        add(blast, 300, 500);

        GImage gold = new GImage("award-gold-large.png");
        add(gold, 600, 700);

        GImage stuff = new GImage("OIP.jpg");
        add(stuff, 1000, 500);

        GLine stuffSpeechLine = new GLine(1400, 500, 1200, 600);
        add(stuffSpeechLine);

        GOval stuffSpeechBubble = new GOval(300, 200);
        stuffSpeechBubble.setFilled(true);
        stuffSpeechBubble.setFillColor(Color.WHITE);
        add(stuffSpeechBubble, 1300, 350);

        GLabel stuffSpeechText = new GLabel("thank you joe biden");
        stuffSpeechText.setFont("Times New Roman-30");
        add(stuffSpeechText, 1350, 450);

        GRect obummer = new G3DRect(1400, 50, 200, 200);
        add(obummer);
    }

    public static void main (String[] args) {
        (new DigitalArtistry()).start(args);
    }
}
