package Hw1.bai6;

import java.lang.reflect.Array;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }
    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }
    public void resize() {
        Class componentType  = array.getClass().getComponentType();
        int newArrayLength = n * 2;
        Object newArray = Array.newInstance(componentType, newArrayLength);
        System.arraycopy(array, 0, newArray, 0, n);
        array = (T[]) newArray;
    }
    @Override
    public void add(T data) {
        if(n > array.length) {
            resize();
        }
        array[n++] = data;
    }

    @Override
    public T get(int i) {
        return array[i];
    }

    @Override
    public void set(int I, T data) {
        array[I] = data;
    }

    @Override
    public void remove(T data) {
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(array[i].equals(data)) {
                index = i;
                break;
            }
        }
//        System.out.println(index);
        for(int i = index; i < n - 1; i++) {
            array[i] = array[i + 1];
        }
        n--;
    }

    public void removeAll(T data) {
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(!array[i].equals(data)) {
                array[index++] = array[i];

            }
        }
        n = index;
    }

    @Override
    public void isContain(T data) {
        for(int i = 0 ; i < n; i++) {
            if(array[i].equals(data)) {
                System.out.println("contain !");
                return;
            }
        }
        System.out.println("does not contain !");
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n && array[currentIndex] != null;
            }
            @Override
            public T next() {
                return array[currentIndex++];
            }
        };
        return iterator;
//        T[] copy = Arrays.copyOf(array, n);
//        // make a list and return an iterator
//        return Arrays.asList(copy).iterator();
    }
    public void rangeCheck(int index, int limit) {
        if(index < 0 || index > limit) {
            System.out.println("Can't execute due to out of range.");
        }
    }
    public void print() {
        System.out.println("SimpleArrayList: ");
        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        SimpleArrayList<String> simpleList = new SimpleArrayList<>();
        simpleList.add("phan tu thu 1");
        simpleList.add("phan tu thu 2");
        simpleList.add("phan tu thu 4");
        simpleList.add("phan tu thu 3");
        simpleList.add("phan tu thu 4");
        simpleList.add("phan tu thu 5");
        simpleList.add("phan tu thu 3");
        simpleList.print();
        /* SimpleArrayList:
            phan tu thu 1
            phan tu thu 2
            phan tu thu 4
            phan tu thu 3
            phan tu thu 4
            phan tu thu 5
            phan tu thu 3
        */

        System.out.println("\ntest get(): ");
        System.out.println("Phan tu thu 2 trong list: " + simpleList.get(1));
//        test get():
//        Phan tu thu 2 trong list: phan tu thu 2

        System.out.println("\ntest set(): ");
        simpleList.set(1,"phan tu thu 2 moi");
        simpleList.print();
//        test set():
//        SimpleArrayList:
//        phan tu thu 1
//        phan tu thu 2 moi
//        phan tu thu 4
//        phan tu thu 3
//        phan tu thu 4
//        phan tu thu 5
//        phan tu thu 3

        System.out.println("\ntest remove(): ");
        simpleList.remove("phan tu thu 4");
        simpleList.print();
//        test remove():
//        SimpleArrayList:
//        phan tu thu 1
//        phan tu thu 2 moi
//        phan tu thu 3
//        phan tu thu 4
//        phan tu thu 5
//        phan tu thu 3

        System.out.println("\ntest removeAll(): ");
        simpleList.removeAll("phan tu thu 3");
        simpleList.print();
//        test removeAll():
//        SimpleArrayList:
//        phan tu thu 1
//        phan tu thu 2 moi
//        phan tu thu 4
//        phan tu thu 5

        System.out.println("\ntest isContain(): ");
        simpleList.isContain("phan tu thu 2 moi");
//        test isContain():
//        contain !

        System.out.println("\ntest iterator(): ");
        Iterator<String> iterator = simpleList.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next() + " ");
//        test iterator():
//        phan tu thu 1
//        phan tu thu 2 moi
//        phan tu thu 4
//        phan tu thu 5
    }
}
