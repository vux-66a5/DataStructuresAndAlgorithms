package Hw1.bai2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestArr1D {
    public static void inputArr(Array1D<Integer> array, Scanner scan) {
        for (int i = 0; i < array.size(); i++) {
            int inputNum = Integer.parseInt(scan.next());
            array.set(i,inputNum);
        }
    }
    public static void printArr(Array1D<Integer> array) {
        System.out.println("cac phan tu trong mang: ");
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
    public static int[] findIndex(Array1D<Integer> array , int x) {
        ArrayList<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) == x) {
                indexList.add(i);
            }
        }
        if(indexList.size()!= 0) {
            int[] indexArr = indexList.stream().mapToInt(i -> i).toArray();
            return indexArr;
        } else {
            return null;
        }
    }
    public static int findElement(Array1D<Integer> array, int idx) {
        return array.get(idx);
    }
    public static void sortDesc(Array1D<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if(array.get(i) < array.get(j)) {
                    int temp = array.get(i);
                    array.set(i,array.get(j));
                    array.set(j,temp);
                }
            }
        }
    }
    public static void sortAsc(Array1D<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if(array.get(i) > array.get(j)) {
                    int temp = array.get(i);
                    array.set(i,array.get(j));
                    array.set(j,temp);
                }
            }
        }
    }
    public static void main(String[] args) {
        Array1D<Integer> arr1D = new Array1D<Integer>(6);
        Scanner scan = new Scanner(System.in);
//      array = [4, 2, 7, 1, 9, 7];

        //Nhap mang
        inputArr(arr1D,scan);

        //in mang cac phan tu dang int
        printArr(arr1D);

        //tim kiem index
        System.out.println("Vi tri cua so 7 trong array: " + Arrays.toString(findIndex(arr1D,7)));

        //tim kiem phan tu
        System.out.println("Gia tri tai vi tri thu 3 la: " + findElement(arr1D,2));

        //test cong 2 phan tu kiem tra xem co phai so nguyen
        System.out.println("Tong cua arr[0] + arr[1] = " + (arr1D.get(0) + arr1D.get(1)));

        //test sap xep
        sortAsc(arr1D);

        //in mang cac phan tu dang String
        System.out.println("Mang sau khi sap xep tang dan: " + arr1D.toString());
    }
}
