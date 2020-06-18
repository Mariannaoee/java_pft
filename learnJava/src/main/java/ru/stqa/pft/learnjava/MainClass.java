package ru.stqa.pft.learnjava;

public class MainClass {

    public static void main(String[] args) {
        Point p1 = new Point();
        p1.x = 6;
        p1.y =7;
        Point p2 = new Point();
        p2.x =3;
        p2.y =7;
        double distanceResult = p1.distance(p1, p2);

        System.out.println("Distance between p1 and p2 = " + distanceResult );
    }
    public static double distance(Point b, Point a) {

        return Math.sqrt((b.x -a.x) *(b.x -a.x)+(b.y -a.y) *(b.y -a.y));

    }

}

