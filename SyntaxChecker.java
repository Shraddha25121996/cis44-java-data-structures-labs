/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Stack;
/**
 *
 * @author shraddhapatel
 */
public class SyntaxChecker {
    // Method to check if symbols are balanced
    public static boolean isBalanced(String line) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            // Push opening symbols
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Handle closing symbols
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty, all symbols matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // true
        String line2 = "int x = (5 + [a * 2]);"; // true
        String line3 = "System.out.println('Hello');)"; // false
        String line4 = "List list = new ArrayList<{String>();"; // false
        String line5 = "if (x > 0) {"; // false

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }

}
