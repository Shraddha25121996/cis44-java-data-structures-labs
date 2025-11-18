/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.simplesorters;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author shraddhapatel
 */
public class AdvancedSortDriver {
    public static void main(String[] args) {
        Comparator<Integer> comp = Comparator.naturalOrder();
        int N = 20;
        Random rand = new Random();

        Integer[] arr1 = new Integer[N];
        for (int i = 0; i < N; i++) arr1[i] = rand.nextInt(100);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("Original: " + Arrays.toString(arr1));

        AdvancedSorters.mergeSort(arr1, comp);
        System.out.println("Merge Sort: " + Arrays.toString(arr1));

        AdvancedSorters.quickSort(arr2, comp);
        System.out.println("Quick Sort: " + Arrays.toString(arr2));
    }
}