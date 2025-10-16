/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import java.util.Random;
import java.util.Arrays;


/**
 *
 * @author shraddhapatel
 */
public class SortingAlgorithms {
        // ---------------- Selection Sort ----------------
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // ---------------- Insertion Sort ----------------
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // ---------------- Merge Sort ----------------
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // ---------------- Test Data Generators ----------------
    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n * 10);
        return arr;
    }

    public static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        return arr;
    }

    public static int[] generateReverseSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i;
        return arr;
    }

    // ---------------- Timing Helper ----------------
    public static long timeAlgorithm(int[] arr, String algorithm) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();

        switch (algorithm.toLowerCase()) {
            case "selection": selectionSort(copy); break;
            case "insertion": insertionSort(copy); break;
            case "merge": mergeSort(copy); break;
            default: System.out.println("Unknown algorithm"); return -1;
        }

        long end = System.nanoTime();
        return end - start; // returns nanoseconds
    }

    // ---------------- Main Method to Run Tests ----------------
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000}; // Add 100000 if desired
        String[] algorithms = {"selection", "insertion", "merge"};
        String[] casesArr = {"Random", "Sorted", "Reverse"};

        for (int n : sizes) {
            System.out.println("\nArray size: " + n);
            int[] random = generateRandomArray(n);
            int[] sorted = generateSortedArray(n);
            int[] reverse = generateReverseSortedArray(n);

            for (String algo : algorithms) {
                long timeRandom = timeAlgorithm(random, algo);
                long timeSorted = timeAlgorithm(sorted, algo);
                long timeReverse = timeAlgorithm(reverse, algo);

                System.out.printf("%s Sort - Random: %d ns, Sorted: %d ns, Reverse: %d ns\n",
                        algo, timeRandom, timeSorted, timeReverse);
            }
        }
    }
}
    
