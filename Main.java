/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shraddhapatel
 */
public class Main {
    public static void main(String[] args) {
        // Create 2 random 2x2 matrices
        Matrix m1 = new Matrix(2, 2);
        Matrix m2 = new Matrix(2, 2);

        m1.populateRandom();
        m2.populateRandom();

        System.out.println("Matrix 1:");
        System.out.println(m1);

        System.out.println("Matrix 2:");
        System.out.println(m2);

        // Addition
        try {
            Matrix sum = m1.add(m2);
            System.out.println("Sum of Matrix 1 and Matrix 2:");
            System.out.println(sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Addition Error: " + e.getMessage());
        }

        // Multiplication
        try {
            Matrix product = m1.multiply(m2);
            System.out.println("Product of Matrix 1 and Matrix 2:");
            System.out.println(product);
        } catch (IllegalArgumentException e) {
            System.out.println("Multiplication Error: " + e.getMessage());
        }
    }
}

