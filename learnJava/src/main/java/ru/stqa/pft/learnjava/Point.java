package ru.stqa.pft.learnjava;

public class Point {

    public double x;
    public double y;



    public static double distance(Point b, Point a) {
        return Math.sqrt((b.x -a.x) *(b.x -a.x)+(b.y -a.y) *(b.y -a.y));

    }



}




