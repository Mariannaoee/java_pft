package ru.stqa.pft.learnjava;

public class Square {
    public double l;//attribute

    public Square(double l) {
        this.l = l;//1.l -attribute, 2.l variable like argument of function
    }
    public double area() {
        return this.l * this.l;
    }

}
