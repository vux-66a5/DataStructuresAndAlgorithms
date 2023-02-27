package Hw2.bai1;

public class BubbleSort {
    static int swaps = 0;
    static int comparisons = 0;

    void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    printArray(arr);
                }
//                printArray(arr);
                comparisons++;
            }
        }

    }

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSort instance = new BubbleSort();
        int arr[] = {8, 22, 7, 9, 31, 19, 5, 13};
        System.out.println("Mảng ban đầu:");
        instance.printArray(arr);
        System.out.println("Trạng thái: ");
        long startTime = System.nanoTime();
        instance.bubbleSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Execution time in micro seconds: " + duration * 0.001);
        instance.bubbleSort(arr);

        System.out.println("Mảng sau khi sắp xếp:");
        instance.printArray(arr);
        System.out.println("Số lần so sánh: " + comparisons);
        System.out.println("Số lần đổi chỗ: " + swaps);
    }
}
