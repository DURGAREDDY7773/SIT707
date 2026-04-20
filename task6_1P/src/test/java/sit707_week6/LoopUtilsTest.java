package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopUtilsTest {

    @Test
    public void testSumNumbersZero() {
        Assert.assertEquals(0, LoopUtils.sumNumbers(0));
    }

    @Test
    public void testSumNumbersOne() {
        Assert.assertEquals(1, LoopUtils.sumNumbers(1));
    }

    @Test
    public void testSumNumbersFive() {
        Assert.assertEquals(15, LoopUtils.sumNumbers(5));
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
    public void testCountEvenNumbersSix() {
        Assert.assertEquals(3, LoopUtils.countEvenNumbers(6));
    }

    @Test
    public void testCountEvenNumbersSeven() {
        Assert.assertEquals(3, LoopUtils.countEvenNumbers(7));
    }
}