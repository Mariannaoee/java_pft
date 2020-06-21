package ru.stqa.pft.learnjava;

public class Rectangle {
    public double a;
    public double b;

    public Rectangle(double a, double b) {
        this.a = a;//1.a -attribute, 2.a variable like argument of function
        this.b = b;
    }
    public double area() {
        return this.a * this.b;
    }
}
