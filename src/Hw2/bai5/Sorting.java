package Hw2.bai5;

import java.util.*;


public class Sorting {
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int swaps = 0;
        int comparisons = 0;
        System.out.println("\n---Bubble Sort---");
        System.out.println("\nMang ban dau: ");
        printArray(arr);
        System.out.println("Trang thai: ");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    T temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swaps++;
                    printArray(arr);
                }
                comparisons++;
            }
        }
        System.out.println("\nSorted Array: ");
        printArray(arr);
        System.out.println("So lan doi cho va so sanh lan luot la: " + swaps + " va " + comparisons);

    }

    static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int swaps = 0;
        int comparisons = 0;
        System.out.println("\n---Insertion Sort---");
        System.out.println("\nMang ban dau: ");
        printArray(arr);
        System.out.println("Trang thai: ");
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; (j > 0) && (arr[j].compareTo(arr[j - 1]) < 0); j--) {
                T temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                swaps++;
                comparisons++;
                printArray(arr);
            }
            comparisons++;
        }
        System.out.println("\nSorted Array: ");
        printArray(arr);
        System.out.println("\nSorted Array: ");
        printArray(arr);
        System.out.println("So lan doi cho va so sanh lan luot la: " + swaps + " va " + comparisons);
    }


    static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int swaps = 0;
        int comparisons = 0;
        System.out.println("\n---Selection Sort---");
        System.out.println("\nMang ban dau: ");
        printArray(arr);
        System.out.println("Trang thai: ");
        for (int i = 0; i < arr.length - 1; i++) {
            int bigindex = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[bigindex]) > 0) {
                    bigindex = j;
                }
                comparisons++;
            }
            T temp = arr[bigindex];
            arr[bigindex] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
            swaps++;
            printArray(arr);
        }
        System.out.println("\nSorted Array: ");
        printArray(arr);
        System.out.println("So lan doi cho va so sanh lan luot la: " + swaps + " va " + comparisons);
    }

    static <T extends Comparable<T>> void printArray(T arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] arr = {7, 3, 2, 1, 6, 4};
//        bubbleSort(arr);
        selectionSort(arr);
//        insertionSort(arr);
    }

}
