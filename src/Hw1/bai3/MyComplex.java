package Hw1.bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class MyComplex {
    double real;
    double imag;

    public MyComplex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public String toString() {

        return "(" + this.real + " + " + this.imag + "i" + ")";
    }

    public MyComplex addNew(MyComplex right) { //adds and subtract "right" into "this" and returns "new Complex".
        MyComplex newComplex = new MyComplex();
        newComplex.real = this.real + right.real;
        newComplex.imag = this.imag + right.imag;
        return newComplex;

//        double real = this.real + that.real;
//        double imag = this.imag + that.imag;
//        return new Complex(real, imag);
    }
    public MyComplex addAll(ArrayList<MyComplex> allComplex) {
        MyComplex sumComplex = new MyComplex(allComplex.get(0).real, allComplex.get(0).imag);
        for(int i = 1; i < allComplex.size(); i++) {
            sumComplex.real += allComplex.get(i).real;
            sumComplex.imag += allComplex.get(i).imag;
        }
        return sumComplex;
    }

    public MyComplex multiply(MyComplex that) {
        double real = this.real * that.real - this.imag * that.imag;
        double imag = this.real * that.imag + this.imag * that.real;
        return new MyComplex(real, imag);
    }
    public MyComplex multiplyAll(ArrayList<MyComplex> allComplex) {

        MyComplex multiComplex = allComplex.get(0);
        for (int i = 1; i < allComplex.size(); i++) {
            multiComplex = multiComplex.multiply(allComplex.get(i));
        }
        return multiComplex;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyComplex myComplex = new MyComplex();
        System.out.print("How many numbers ?: ");
        int n = Integer.parseInt(scan.nextLine());
        ArrayList<MyComplex> allComplex = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            System.out.print("Enter complex number " + (i+1) + "(real and imaginary part): ");
            double realPart = Double.parseDouble(scan.next());
            double imagPart= Double.parseDouble(scan.next());
            MyComplex number = new MyComplex(realPart, imagPart);
            allComplex.add(number);
        }

        //number 1 info
        System.out.println("Number 1 is: " + allComplex.get(0));
        System.out.println();

        //number 2 info
        System.out.println("Number 2 is: " + allComplex.get(1));
        System.out.println();

        //add
        System.out.println(allComplex.get(0) + " + " + allComplex.get(1) + " = " + (allComplex.get(0)).addNew(allComplex.get(1)));

        //addAll
        System.out.println(myComplex.addAll(allComplex));

        //multiply
        System.out.println(allComplex.get(0) + " + " + allComplex.get(1) + " = " + (allComplex.get(0)).multiply(allComplex.get(1)));

        //multiplyAll
        System.out.println(myComplex.multiplyAll(allComplex));
    }

}