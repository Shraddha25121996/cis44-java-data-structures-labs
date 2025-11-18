/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.simplesorters;

import java.util.Arrays;
import java.util.Comparator;

public class SimpleSortDriver {
    public static void main(String[] args) {
        Comparator<Integer> comp = Comparator.naturalOrder();

        Integer[] arr1 = {5, 1, 9, 3, 7, 6};
        Integer[] arr1_copy = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test 1: Unsorted Array ---");
        System.out.println("Original: " + Arrays.toString(arr1));
        SimpleSorters.bubbleSort(arr1, comp);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

        System.out.println("Original: " + Arrays.toString(arr1_copy));
        SimpleSorters.insertionSort(arr1_copy, comp);
        System.out.println("Insertion Sort: " + Arrays.toString(arr1_copy));
    }
}