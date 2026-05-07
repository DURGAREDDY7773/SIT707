package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "YOUR_STUDENT_ID";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Durga Reddy";
		Assert.assertNotNull("Student name is null", studentName);
	}

	/*
	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		
		WeatherController wController = WeatherController.getInstance();
		
		int nHours = wController.getTotalHours();
		double minTemperature = 1000;
		
		for (int i = 0; i < nHours; i++) {
			double temperatureVal = wController.getTemperatureForHour(i + 1); 
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}
		
		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
		wController.close();		
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		
		WeatherController wController = WeatherController.getInstance();
		
		int nHours = wController.getTotalHours();
		double maxTemperature = -1;
		
		for (int i = 0; i < nHours; i++) {
			double temperatureVal = wController.getTemperatureForHour(i + 1); 
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}
		
		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
		wController.close();
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		
		WeatherController wController = WeatherController.getInstance();
		
		int nHours = wController.getTotalHours();
		double sumTemp = 0;
		
		for (int i = 0; i < nHours; i++) {
			double temperatureVal = wController.getTemperatureForHour(i + 1); 
			sumTemp += temperatureVal;
		}
		
		double averageTemp = sumTemp / nHours;
		
		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
		wController.close();
	}
	*/
	
	@Test
	public void testTemperaturePersist() {
		System.out.println("+++ testTemperaturePersist +++");
		
		// Arrange
		WeatherController wController = WeatherController.getInstance();
		Date fixedDate = new Date();
		wController.setFixedDate(fixedDate);
		String expectedTime = new SimpleDateFormat("H:m:s").format(fixedDate);
		
		// Act
		String persistTime = wController.persistTemperature(10, 19.5);
		System.out.println("Persist time: " + persistTime + ", expected time: " + expectedTime);
		
		// Assert
		Assert.assertEquals(expectedTime, persistTime);
		
		wController.close();
	}
}
