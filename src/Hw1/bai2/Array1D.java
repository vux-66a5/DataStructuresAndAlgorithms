package Hw1.bai2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//https://www.delftstack.com/howto/java/generic-array-in-java/
public class Array1D<T> {
    private T[] array;
    public Array1D(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public T get(int i) {
        return array[i];
    }

    public void set(int i, T data) {
        array[i] = data;
    }

    public int size() {
        return array.length;
    }
    public String toString() {
        return Arrays.toString(array);
    }
}
