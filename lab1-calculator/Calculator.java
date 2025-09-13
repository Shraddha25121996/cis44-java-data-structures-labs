/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.Scanner;

/**
 *
 * @author shraddhapatel
 */
public class Calculator{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double result = 0;  // Current value on the calculator screen
        double inputNumber;
        String operator = "";

        System.out.println("Simple Calculator Simulation");
        System.out.println("Type 'exit' to quit the program.");

        while (true) {
            System.out.print("Enter number or operator (+, -, *, /, =): ");
            String input = scanner.nextLine();

            // Check if user wants to exit
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Calculator exited.");
                break;
            }

            try {
                // If the input is a number
                inputNumber = Double.parseDouble(input);

                if (operator.isEmpty()) {
                    // First number entered
                    result = inputNumber;
                } else {
                    // Perform calculation based on previous operator
                    switch (operator) {
                        case "+" -> result += inputNumber;
                        case "-" -> result -= inputNumber;
                        case "*" -> result *= inputNumber;
                        case "/" -> result /= inputNumber;
                        default -> System.out.println("Unknown operator!");
                    }
                    operator = ""; // Reset operator after calculation
                }

                // Show result on calculator screen
                System.out.println("Screen: " + result);

            } catch (NumberFormatException e) {
                // If input is not a number, treat it as operator
                if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                    operator = input;
                } else if (input.equals("=")) {
                    // Show current result
                    System.out.println("Screen: " + result);
                } else {
                    System.out.println("Invalid input. Enter a number or valid operator (+, -, *, /, =).");
                }
            }
        }

        scanner.close();
    }
}