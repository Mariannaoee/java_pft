package ru.stqa.pft.learnjava;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPoint() {
        Point p1 = new Point(5,2);
        Point p2 = new Point(4,2);
        p1.x =5;
        p1.y =7;
        p2.x =4;
        p2.y =2;
        double distanceResult = p1.distance(p2);

        Assert.assertEquals(distanceResult,5.0990195135927845);

    }
}
