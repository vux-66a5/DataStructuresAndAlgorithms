package Hw1.bai4;

import java.util.Scanner;

public class Sphere {
    double radius;
    double x;
    double y;
    double z;

    public Sphere() {

    }

    public Sphere(double radius, double x, double y, double z) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String toString() {
        return "Sphere(x,y,z) = (" + this.x + "," + this.y + "," + this.z + "), r = " + this.radius;
    }

    public double SphereLateralArea(Sphere inSphere) {
        return 4 * Math.PI * inSphere.radius * inSphere.radius;
    }

    public double SphereVolume(Sphere inSphere) {
        return (double) 4 / 3 * Math.PI * inSphere.radius * inSphere.radius * inSphere.radius;
    }

    public double distanceBetween(Sphere sphere1, Sphere sphere2) {
        return Math.sqrt(Math.pow((sphere2.x - sphere1.x), 2) + Math.pow((sphere2.y - sphere1.y), 2) + Math.pow((sphere2.z - sphere1.z), 2));
    }

    public boolean areColliding(Sphere sphere1, Sphere sphere2) {
        return distanceBetween(sphere1, sphere2) <= (sphere1.radius + sphere2.radius);
    }

    public boolean areInside(Sphere sphere1, Sphere sphere2) {
        return distanceBetween(sphere1, sphere2) < (sphere2.radius - sphere1.radius);
    }

    public static void main(String[] args) {
        Sphere driver = new Sphere();
        Scanner scan = new Scanner(System.in);

        System.out.print("Input sphere 1 (radius x y z): ");
        double radius1 = Double.parseDouble(scan.next());
        double x1 = Double.parseDouble(scan.next());
        double y1 = Double.parseDouble(scan.next());
        double z1 = Double.parseDouble(scan.next());
        Sphere sphere1 = new Sphere(radius1, x1, y1, z1);

        System.out.print("Input sphere 2 (radius x y z): ");
        double radius2 = Double.parseDouble(scan.next());
        double x2 = Double.parseDouble(scan.next());
        double y2 = Double.parseDouble(scan.next());
        double z2 = Double.parseDouble(scan.next());
        Sphere sphere2 = new Sphere(radius2, x2, y2, z2);

        System.out.println("Sphere 1: " + sphere1);
        System.out.println("Sphere 2: " + sphere2);

        //Dien tich xung quanh
        System.out.println("Dien tich xung quanh sphere 1: " + driver.SphereLateralArea(sphere1));

        //The tich
        System.out.println("The tich sphere 2: " + driver.SphereVolume(sphere2));

        //Co giao nhau
        if (driver.areColliding(sphere1, sphere2)) {
            System.out.println("2 hinh cau giao nhau");
        } else {
            System.out.println("2 hinh cau khong giao nhau");
        }

        //Co bao nhau
        if (driver.areInside(sphere1, sphere2)) {
            System.out.println("Hình cầu 2 bao hình cầu 1");
        } else if (driver.areInside(sphere1, sphere2)) {
            System.out.println("Hình cầu 1 bao hình cầu 2");
        } else {
            System.out.println("2 hình cầu không bao nhau");
        }
    }

}
