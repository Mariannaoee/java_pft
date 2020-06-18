package ru.stqa.pft.learnjava;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {
    @Test
    public void testArea() {
        Square s = new Square();//create new square
        s.l = 5;
        Assert.assertEquals(s.area(), 25.0);
    }

}
