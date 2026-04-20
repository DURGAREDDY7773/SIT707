package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "YOUR_STUDENT_ID";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "YOUR_FULL_NAME";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(5));
    }

    @Test
    public void testTrueNumberIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testCancelWeatherAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    public void testCancelWeatherAdviceByRain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 6.1));
    }

    @Test
    public void testCancelWeatherAdviceByWindAndRain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
    }

    @Test
    public void testWarnWeatherAdviceByWind() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
    }

    @Test
    public void testWarnWeatherAdviceByRain() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 4.5));
    }

    @Test
    public void testAllClearWeatherAdvice() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeatherAdviceWithNegativeInput() {
        WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
    }

    @Test
    public void testPrimeForOne() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
    }

    @Test
    public void testPrimeForEvenNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testPrimeForOddNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(5));
    }

    @Test
    public void testPrimeForOddCompositeNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(9));
    }
}