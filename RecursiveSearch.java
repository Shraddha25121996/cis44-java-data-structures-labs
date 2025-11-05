/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.recursivesearch;
// Helper class for the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

/**
 *
 * @author shraddhapatel
 */
public class RecursiveSearch {
       
    /**
     * Lab 2a: Recursive Binary Search (Helper Method)
     */
    public static int recursiveBinarySearch(int[] arr, int key, int low, int high) {
        // Base Case: If the search range is invalid, the key is not present
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == key) {
            return mid; // Found
        } else if (key < arr[mid]) {
            return recursiveBinarySearch(arr, key, low, mid - 1); // Left half
        } else {
            return recursiveBinarySearch(arr, key, mid + 1, high); // Right half
        }
    }

    // Public wrapper method
    public static int searchArray(int[] arr, int key) {
        return recursiveBinarySearch(arr, key, 0, arr.length - 1);
    }

    /**
     * Lab 2b: Binary Search Tree Search
     */
    public Node searchBST(Node root, int key) {
        // Base Case: tree empty or found at root
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return searchBST(root.left, key); // Search left subtree
        } else {
            return searchBST(root.right, key); // Search right subtree
        }
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        System.out.println("--- Lab 2: Recursive Search Algorithms ---");

        // Test Recursive Binary Search
        int[] sortedData = {10, 20, 30, 40, 50, 60};
        System.out.println("Recursive Binary Search:");
        System.out.println("Find 40: Index " + searchArray(sortedData, 40)); // Expected: 3
        System.out.println("Find 15: Index " + searchArray(sortedData, 15)); // Expected: -1

        // Build a sample BST
        RecursiveSearch bstSearcher = new RecursiveSearch();
        Node root = new Node(40);
        root.left = new Node(20);
        root.right = new Node(60);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.right.left = new Node(50);

        System.out.println("\nBinary Search Tree Search:");
        Node result1 = bstSearcher.searchBST(root, 30);
        System.out.println("Find 30: " + (result1 != null ? "Found (" + result1.key + ")" : "Not Found")); // Expected: Found
        
        Node result2 = bstSearcher.searchBST(root, 45);
        System.out.println("Find 45: " + (result2 != null ? "Found" : "Not Found")); // Expected: Not Found
    }
}