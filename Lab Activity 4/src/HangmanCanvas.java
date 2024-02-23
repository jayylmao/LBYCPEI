/*
 * File: HangmanCanvas.java
 * ---------------------
 * This class holds the graphics elements to the Hangman game.
 * Author: Cobalt - M.Cabatuan
 * Date modified: 06/11/2019
 */


import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class HangmanCanvas extends GCanvas {

    private static final int TEXT_HEIGHT = 20;   // you can modify this to suit your ascii art
    private static final int TEXT_X_OFFSET = 12;   // you can modify this to suit your ascii art
    private int textX;
    private int textY;


    /**
     * Resets the display so that only the hangman scaffold appears
     */
    public void reset() {
        // Sample graphics object
        textX = TEXT_X_OFFSET;
        textY = TEXT_HEIGHT;
    }

    public void printText(String text){
        GLabel line = new GLabel(text);
        line.setFont("Courier New");
        textY += TEXT_HEIGHT;
        add(line,  textX , textY );
    }

    /* Write your methods here */

    // clears all elements on the canvas.
    public void clear() {
        System.out.println("ELEMENTS ON CANVAS: " + getElementCount());
        textX = TEXT_X_OFFSET;
        textY = TEXT_HEIGHT;

        // iterate through each element and remove it.
        for (int i = 0; i < getElementCount(); i++) {
            System.out.println("element: " + getElement(i));
            GObject element = getElement(i);
            remove(element);
        }
    }
}