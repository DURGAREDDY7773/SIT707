package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224658749";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Durga reddy kankanala";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testFalseNumberIsEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(5));
	}

	@Test
	public void testTrueNumberIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(8));
	}

	@Test
	public void testZeroIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(0));
	}

	@Test
	public void testNegativeEvenNumber() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(-4));
	}

	@Test
	public void testNegativeOddNumber() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(-3));
	}

	@Test
	public void testPrimeNumber() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(13));
	}

	@Test
	public void testNonPrimeNumber() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(9));
	}

	@Test
	public void testPrimeTwo() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
	}

	@Test
	public void testPrimeOne() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
	}

	@Test
	public void testPrimeZero() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(0));
	}

	@Test
	public void testPrimeNegativeNumber() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(-5));
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
    	Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 2.0));
    }

    @Test
    public void testWarnWeatherAdviceByRain() {
    	Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 4.5));
    }

    @Test
    public void testAllClearWeatherAdvice() {
    	Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
    }

    @Test
    public void testBoundaryWind45() {
    	Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(45.0, 2.0));
    }

    @Test
    public void testBoundaryRain4() {
    	Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 4.0));
    }

    @Test
    public void testBoundaryWind70() {
    	Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(70.0, 0.0));
    }

    @Test
    public void testBoundaryRain6() {
    	Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 6.0));
    }
}