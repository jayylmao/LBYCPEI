/*
 * File: MathHandler.java   (!!! TO BE MODIFIED !!! In the   YOUR CODE HERE   parts)
 * ---------------------
 *  This class is a helper class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date created: July 22, 2019
 *  Last modified: Aug 3, 2022
 */




public class MathHandler {

    public static int evaluate(int operand1, int operand2, char operator) {
        // No modifications needed here!!!
        int result;
        switch (operator) {
            case '+':
                result = add(operand1, operand2);
                break;
            case '-':
                result = subtract(operand1, operand2);
                break;
            case '×':
                result = multiply(operand1, operand2);
                break;
            case '÷':
                result = divide(operand1, operand2);
                break;
            default:
                result = 0;
        }
        return result;
    }

    public static double evaluate(double operand1, double operand2, char operator) {
        // No modifications needed here!!!
        double result;
        switch (operator) {
            case '+':
                result = add(operand1, operand2);
                break;
            case '-':
                result = subtract(operand1, operand2);
                break;
            case '×':
                result = multiply(operand1, operand2);
                break;
            case '÷':
                result = divide(operand1, operand2);
                break;
            case '^':
                result = exponent(operand1, operand2);
                System.out.println(result);
                break;
            case 's':
                result = sin(operand1);
                System.out.println(result);
                break;
            case 'c':
                result = cos(operand1);
                System.out.println(result);
                break;
            case 't':
                result = tan(operand1);
                System.out.println(result);
                break;
            default:
                result = 0;
        }
        return result;
    }


    /**
     * Returns the sum of operand1 and operand2
     * @param operand1
     * @param operand2
     * @return
     */
    public static int add(int operand1, int operand2) {
        /* YOUR CODE HERE */
        return operand1 + operand2;
    }

    public static double add(double operand1, double operand2) {
        /* YOUR CODE HERE */
        return operand1 + operand2;
    }


    public static int subtract(int operand1, int operand2) {
        /* YOUR CODE HERE */
        return operand1 - operand2;
    }

    public static double subtract(double operand1, double operand2) {
        /* YOUR CODE HERE */
        return operand1 - operand2;
    }


    public static int divide(int operand1, int operand2) {
        /* YOUR CODE HERE */
        return operand1 / operand2;
    }

    public static double divide(double operand1, double operand2) {
        /* YOUR CODE HERE */
        return operand1 / operand2;
    }

    public static int multiply(int operand1, int operand2) {
        /* YOUR CODE HERE */
        return operand1 * operand2;
    }

    public static double multiply(double operand1, double operand2) {
        /* YOUR CODE HERE */
        return operand1 * operand2;
    }

    public static double sin(double operand1) {
        return Math.sin(operand1);
    }

    public static double cos(double operand1) {
        return Math.cos(operand1);
    }

    public static double tan(double operand1) {
        return Math.tan(operand1);
    }

    public static double exponent(double operand1, double operand2) {
        return Math.pow(operand1, operand2);
    }
}