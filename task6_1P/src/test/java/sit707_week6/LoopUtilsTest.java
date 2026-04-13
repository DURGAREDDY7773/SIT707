package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopUtilsTest {

    @Test
    public void testSumUpToZero() {
        Assert.assertEquals(0, LoopUtils.sumUpTo(0));
    }

    @Test
    public void testSumUpToOne() {
        Assert.assertEquals(1, LoopUtils.sumUpTo(1));
    }

    @Test
    public void testSumUpToFive() {
        Assert.assertEquals(15, LoopUtils.sumUpTo(5));
    }

    @Test
    public void testSumUpToTen() {
        Assert.assertEquals(55, LoopUtils.sumUpTo(10));
    }

    @Test
    public void testCountEvenNumbersZero() {
        Assert.assertEquals(0, LoopUtils.countEvenNumbers(0));
    }

    @Test
    public void testCountEvenNumbersOne() {
        Assert.assertEquals(0, LoopUtils.countEvenNumbers(1));
    }

    @Test
    public void testCountEvenNumbersTwo() {
        Assert.assertEquals(1, LoopUtils.countEvenNumbers(2));
    }

    @Test
    public void testCountEvenNumbersFive() {
        Assert.assertEquals(2, LoopUtils.countEvenNumbers(5));
    }

    @Test
    public void testCountEvenNumbersTen() {
        Assert.assertEquals(5, LoopUtils.countEvenNumbers(10));
    }
}