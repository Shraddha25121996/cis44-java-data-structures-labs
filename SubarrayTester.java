/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
import java.util.Arrays;


/**
 *
 * @author shraddhapatel
 */
public class SubarrayTester {
      public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            int[] arr = generateRandomArrayWithNegatives(n);

            long startBF = System.nanoTime();
            int maxBF = MaxSubarraySolver.bruteForceMaxSum(arr);
            long endBF = System.nanoTime();

            long startKadane = System.nanoTime();
            int maxKadane = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            long endKadane = System.nanoTime();

            System.out.println("\nArray size: " + n);
            System.out.println("Brute-Force: Max Sum = " + maxBF + ", Time = " + (endBF - startBF) + " ns");
            System.out.println("Kadane's   : Max Sum = " + maxKadane + ", Time = " + (endKadane - startKadane) + " ns");
        }
    }

    // Generate random array including negative numbers
    public static int[] generateRandomArrayWithNegatives(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(2001) - 1000; // range [-1000, 1000]
        }
        return arr;
    }
}  