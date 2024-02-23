/*
 * File: Calculator.java (Find and solve bugs if they exist.)
 * ---------------------
 * This class is the main class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date created: July 22, 2019
 *  Last modified: Aug 3, 2022
 */


import acm.graphics.GObject;
import acm.program.*;
import java.awt.event.MouseEvent;


public class App extends GraphicsProgram {

    private static final double CANVAS_WIDTH = 540;    // Calculator width
    private static final double CANVAS_HEIGHT = 740;   // Calculator height
    private CalculatorLayout calculatorLayout;         // Instantiate the Layout Object

    private char opBuffer;                             // Stores the operator
    private double operand1;                           // Stores the operand digits
    private String result;                             // Stores the results
 
    private boolean isFirstOp;                         // Checks if first operator
    private boolean isPriorEquals;                     // Checks if it is prior to equal sign 
    private boolean isFirstPoint;                      // Checks if first decimal point
    private boolean isDeletable;                       // Checks if it is deletable


    public void run() {
        setTitle("LBYCPEI Calculator");
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        calculatorLayout = new CalculatorLayout(getHeight());
        add(calculatorLayout);
        initBooleans();
        addMouseListeners();                             // Adds the program as both a MouseListener and MouseMotionListener to the canvas.
                                                         //  (Refer to: https://cs.stanford.edu/people/eroberts/jtf/javadoc/complete/acm/program/GraphicsProgram.html)
    }


    public void mouseClicked(MouseEvent e) {
        // This method runs everytime you click the mouse, thus it enables you to access the mouse events
       
        
        GObject element = calculatorLayout.getElementAt(e.getX(), e.getY());
        // getElementAt() Returns the topmost graphical object that contains the point (x, y), or null if no such object exists.
        // Documentation : https://cs.stanford.edu/people/eroberts/jtf/javadoc/complete/acm/program/GraphicsProgram.html
        
        if (element instanceof MyButton) {
            String input = ((MyButton) element).getText();    // Gets the text associated with the button. e.g. C, CE, ⌫, ±, 0, 1,...,9, etc.
             // e.g. input = 0  
            
            // I. Handle special cases: Clear Element, Clear All, and  Delete
            if (input.equals("CE ")) {
                calculatorLayout.clearMainDisplay();
                calculatorLayout.clearMemoElement(opBuffer);
                System.out.println("Clear Element");
                return;
            }
            if (input.equals("C")) {
                calculatorLayout.clearMainDisplay();
                calculatorLayout.clearMemoDisplay();
                initBooleans();
                System.out.println("Clear Called");
                return;
            }
            if (input.equals("⌫") && isDeletable) {   // ⌫ symbolizes delete
                calculatorLayout.deleteOneCharacter();
                System.out.println("Delete Called");
                return;
            }

            // II. Handle arithmetic symbols and operations

            char symbol = input.charAt(0); // Aiming for 0,1,2,3,4,5,6,7,8,9,.,±,=,+,-,x,÷

            if (symbol == '±' && isDeletable) {
                calculatorLayout.negateElement(opBuffer);
                System.out.println("Negation Called");
                return;
            }

            if ((symbol >= '0' && symbol <= '9') || symbol == '.') {
                isDeletable = true;
                if (symbol == '.') {
                    if (!isFirstPoint) {
                        return;
                    } else {
                        isFirstPoint = false;
                    }
                }
                if (isPriorEquals) {
                    calculatorLayout.clearMainDisplay();
                    isPriorEquals = false;
                    System.out.println("Digit: Prior Equals");
                }
                calculatorLayout.setMemoDisplay(symbol);
                calculatorLayout.setMainDisplay(symbol);
                System.out.println("Digit: Prior Not Equals");
                return;
            }


            double operand2;
            if (isOperator(symbol)) {
                if (isFirstOp && !isPriorEquals) {
                    operand1 = Double.parseDouble(calculatorLayout.getMainDisplay());
                    calculatorLayout.setMemoDisplay(symbol);
                    opBuffer = symbol;
                    isFirstOp = false;
                    System.out.println("Operator: First Operation and Not prior equals");
                } else if (isPriorEquals) {
                    calculatorLayout.setMemoDisplay(result + symbol);
                    opBuffer = symbol;
                    isFirstOp = false;
                    System.out.println("Operator: Prior equals!");
                } else if (symbol == 's' || symbol == 'c' || symbol == 't' && !isFirstOp) {
                    operand1 = Double.parseDouble(calculatorLayout.getMainDisplay());
                    operand2 = MathHandler.evaluate(operand1, 0, opBuffer);
                    result = "" + operand2;
                    calculatorLayout.setMainDisplay(result);
                } else {
                    operand2 = Double.parseDouble(calculatorLayout.getMainDisplay());
                    operand1 = MathHandler.evaluate(operand1, operand2, opBuffer);
                    result = "" + operand1;
                    result = result.contains(".") ? result.replaceAll("0*$", "").replaceAll("\\.$", "") : result;
                    calculatorLayout.setMainDisplay(result);
                    calculatorLayout.setMemoDisplay(symbol);
                    isDeletable = false;
                    System.out.println("Operator: Second operator");
                }
                calculatorLayout.clearNumBuffer();
                isFirstPoint = true;
            }
            if (symbol == '=') {
                operand2 = Double.parseDouble(calculatorLayout.getMainDisplay());
                operand1 = MathHandler.evaluate(operand1, operand2, opBuffer);
                result = "" + operand1;
                result = result.contains(".") ? result.replaceAll("0*$", "").replaceAll("\\.$", "") : result;
                calculatorLayout.setMainDisplay(result);
                calculatorLayout.clearMemoDisplay();
                initBooleans();
                System.out.println("Equals: evaluated");
                System.out.println("operand1 = " + operand1);
                System.out.println("operand2 = " + operand2);
            }
            if (symbol == 's') {
                calculatorLayout.clearMemoDisplay();
                calculatorLayout.clearMainDisplay();
                calculatorLayout.setMemoDisplay("sin " + operand1);
                calculatorLayout.setMainDisplay("sin " + operand1);
            }
            if (symbol == 'c') {
                calculatorLayout.clearMemoDisplay();
                calculatorLayout.clearMainDisplay();
                calculatorLayout.setMemoDisplay("cos " + operand1);
                calculatorLayout.setMainDisplay("cos " + operand1);
            }
            if (symbol == 't') {
                calculatorLayout.clearMemoDisplay();
                calculatorLayout.clearMainDisplay();
                calculatorLayout.setMemoDisplay("tan " + operand1);
                calculatorLayout.setMainDisplay("tan " + operand1);
            }
        }
    }

    private void initBooleans() {
        isFirstOp = true;
        isPriorEquals = true;
        isDeletable = false;
        isFirstPoint = true;
    }

    private boolean isOperator(char symbol) {
        return (symbol == '+' || symbol == '-' || symbol == '×' || symbol == '÷' || symbol == '^' || symbol == 's' || symbol == 'c' || symbol == 't');
    }

    // Solves java.lang.NoClassDefFoundError
    public static void main(String[] args) {
        (new App()).start(args);
    }
}
