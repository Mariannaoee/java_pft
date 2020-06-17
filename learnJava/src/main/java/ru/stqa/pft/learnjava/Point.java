package ru.stqa.pft.learnjava;

public class Point {

    public double name;
    public double age;

    public static void main(String[] args) {

        Point p1 = new Point();
        p1.name = 6;
        p1.age =7;
        Point p2 = new Point();
        p2.name =3;
        p2.age =7;


       System.out.println("Distance between p1 and p2 = " + distance(p1, p2));
    }

    public static double distance(Point p1, Point p2) {

        return Math.sqrt((p1.name -p2.name) *(p1.name -p2.name)+(p1.age -p2.age) *(p1.age -p2.age));

    }

}




