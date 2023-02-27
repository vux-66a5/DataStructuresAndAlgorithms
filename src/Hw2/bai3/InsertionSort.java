package Hw2.bai3;

public class InsertionSort {
    static int swaps = 0;
    static int comparisons = 0;

    void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {

            int j = i;

            // compare i with sorted elements and insert it
            // sorted elements: [0..i-1]
            while (j > 0 && arr[j] < arr[j - 1]) {

                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                swaps++;
                comparisons++;  // loop condition true

                j--;
            }
            comparisons++; // checking loop condition when false
        }
    }

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort instance = new InsertionSort();
        int arr[] = {12, 11, 13, 5, 6};
        System.out.println("Mảng ban đầu:");
        instance.printArray(arr);
        System.out.println("Trạng thái: ");
        instance.insertionSort(arr);
        System.out.println("Mảng sau khi sắp xếp:");
        instance.printArray(arr);
        System.out.println("Số lần so sánh: " + comparisons);
        System.out.println("Số lần đổi chỗ: " + swaps);
    }
}
