/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.searchcomparison;

/**
 *
 * @author shraddhapatel
 */
public class SearchComparison {

    /**
     * Lab 1a: Iterative Linear Search
     */
    public static int linearSearch(int[] arr, int key) {
        int comparisonCounter = 0; // Count comparisons
        for (int i = 0; i < arr.length; i++) {
            comparisonCounter++;
            if (arr[i] == key) {
                System.out.println("Linear Search Comparisons: " + comparisonCounter);
                return i;
            }
        }
        System.out.println("Linear Search Comparisons: " + comparisonCounter);
        return -1;
    }

    /**
     * Lab 1b: Iterative Binary Search
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int comparisonCounter = 0; // Count comparisons

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisonCounter++;
            if (arr[mid] == key) {
                System.out.println("Binary Search Comparisons: " + comparisonCounter);
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Binary Search Comparisons: " + comparisonCounter);
        return -1;
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData =   {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        // Test Linear Search
        System.out.println("Linear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9)); // Expected: 4
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3)); // Expected: -1

        // Test Binary Search
        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9)); // Expected: 3
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3)); // Expected: -1
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30)); // Expected: 7
    }
}