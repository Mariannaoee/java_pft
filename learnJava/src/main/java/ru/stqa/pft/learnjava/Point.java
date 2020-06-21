package ru.stqa.pft.learnjava;

public class Point {

    public double x;//attribute
    public double y;//attribute

    public Point(double x1, double y1) {
        this.x = x1;//x attribute, x1 variable like argument of function
        this.y = y1;
    }
    public  double distance( Point p2) {
        return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
    }

}




