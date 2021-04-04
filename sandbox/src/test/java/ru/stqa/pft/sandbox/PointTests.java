package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    // тест на две точки с разными координатами, включая отрицательные значения
    public void test1(){
        Point p1 = new Point(-1,4);
        Point p2 = new Point(-2,-3);
        Assert.assertEquals(Math.round(p1.distance(p2)), 8);
    }

    @Test
    // тест для двух точек с разным координатами
    public void test2(){
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        Assert.assertEquals(Math.round(p1.distance(p2)), 1);
    }

    @Test
    //тест на две точки с равными координатами
    public void test3() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Assert.assertEquals(Math.round(p1.distance(p2)), 0);
    }
}
