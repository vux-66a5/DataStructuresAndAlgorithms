package Hw2.bai2;

public class SelectionSort {
    static int swaps = 0;
    static int comparisons = 0;

    void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {

            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
                comparisons++;
            }

            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
                swaps++;
                printArray(arr);
            }
        }
    }

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort instance = new SelectionSort();
        int arr[] = {5, 6, 13, 11, 12};
        System.out.println("Mảng ban đầu:");
        instance.printArray(arr);
        System.out.println("Trạng thái: ");
        instance.selectionSort(arr);
        System.out.println("Mảng sau khi sắp xếp:");
        instance.printArray(arr);
        System.out.println("Số lần so sánh: " + comparisons);
        System.out.println("Số lần đổi chỗ: " + swaps);
    }
}
