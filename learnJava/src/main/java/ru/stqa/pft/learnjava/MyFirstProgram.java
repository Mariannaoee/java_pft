package ru.stqa.pft.learnjava;

import java.sql.SQLOutput;

public class MyFirstProgram {
    public static void main(String[] args) {

        Square s = new Square(5);
        System.out.println("Square area with side " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(5,6);
        System.out.println("Rectangle area with side " + r.a + " and "+ r.b + " = " + r.area());
    }


}
