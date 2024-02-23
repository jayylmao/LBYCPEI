/*
 * File: MyButton.java (!!! TO BE MODIFIED !!! In the   YOUR CODE HERE   parts)
 * ---------------------
 * This class is a custom button class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date modified: July 22, 2019
 *  Last modified: Aug 3, 2022
 */


import acm.graphics.GCompound;  // https://cs.stanford.edu/people/eroberts/jtf/javadoc/student/acm/graphics/GCompound.html 
import acm.graphics.GLabel;     // https://cs.stanford.edu/people/eroberts/jtf/javadoc/student/acm/graphics/GLabel.html 
import acm.graphics.GRect;      // https://cs.stanford.edu/people/eroberts/jtf/javadoc/student/acm/graphics/GRect.html


public class MyButton extends GCompound {

    private static final String FONT = "SansSerif-bold-64";
    private GRect key;           // https://cs.stanford.edu/people/eroberts/jtf/javadoc/student/acm/graphics/GRect.html
    private GLabel keyText;      // https://cs.stanford.edu/people/eroberts/jtf/javadoc/student/acm/graphics/GLabel.html 

    public MyButton(double x, double y, double width, double height, String text) {
        // This method draws the Button object which is composed of GRect and GLabel objects
        key = new GRect(x, y, width, height);
        keyText = new GLabel(text);
        keyText.setFont("SansSerif-40");

        add(key);
        add(keyText, key.getCenterX() - (keyText.getWidth() / 2), key.getCenterY());
    }

    public String getText() {
        // This method returns the text associated with the button
        return keyText.getLabel();
    }

    private double getCenterX(double width, double labelWidth) {
        // No need to modify this method. You may use this to center the GLabel in the button
        return (width - labelWidth) / 2.0f;
    }

    private double getCenterY(double height, double ascent) {
        // No need to modify this method. You may use this to center the GLabel in the button  
        return (ascent + (height - ascent) / 2.0f);
    }

    public void setText(String text) {
        // This method modifies the keyText of the button
        keyText.setLabel(text);
    }
}
