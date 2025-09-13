/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.Random;
/**
 *
 * @author shraddhapatel
 */
public class DotProduct {
    public static void main(String[] args) {
            int n = 5; //size of arrays
            int[] a = new int[n];
            int[] b = new  int[n];
            int[] c = new int[n];
            
            Random rand = new Random();
            // Fill arrays a and b with random (0 to 9)
            for (int i = 0; i<n; i++) {
                a[i] = rand.nextInt(10);
                b[i] = rand.nextInt(10);
                c[i] = a[i] * b[i]; 
            }
            //print arrays
            System.out.print("Array a:");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            System.out.print("Array b; ");
            for (int i= 0; i < n; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
            
            System.out.print("Array c (a[i]*b[i]): ");
            for (int i= 0; i<n; i++) {
                System.out.print(c[i] + " ");
            }
            System.out.println();
            
         }
            
}
