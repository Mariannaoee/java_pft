package ru.stqa.pft.learnjava;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPoint() {
        Point a = new Point();
        Point b = new Point();
        a.x =5;
        a.y =7;
        b.x =4;
        b.y =2;
        double distanceResult = a.distance(a, b);

        Assert.assertEquals(distanceResult,5.0990195135927845);

    }
}
