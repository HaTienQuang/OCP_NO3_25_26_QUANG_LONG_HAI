package com.myapp.calculator;

public class CalculatorController {
    private String current = "";
    private double operand1 = 0;
    private String operator = "";

    public String processInput(String input) {
        if (input.matches("[0-9]")) {
            current += input;
            return current;
        } else if (input.matches("[+\-*/]")) {
            operand1 = Double.parseDouble(current);
            operator = input;
            current = "";
            return operator;
        } else if (input.equals("=")) {
            double operand2 = Double.parseDouble(current);
            double result;

            switch (operator) {
                case "+": result = operand1 + operand2; break;
                case "-": result = operand1 - operand2; break;
                case "*": result = operand1 * operand2; break;
                case "/":
                    if (operand2 == 0) throw new ArithmeticException("Chia cho 0");
                    result = operand1 / operand2;
                    break;
                default: return current;
            }

            current = String.valueOf(result);
            return current;
        } else if (input.equals("C")) {
            current = "";
            operand1 = 0;
            operator = "";
            return "";
        }
        return current;
    }
}
