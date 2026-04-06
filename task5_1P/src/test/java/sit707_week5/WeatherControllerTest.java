package sit707_week5;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] hourlyTemperatures;
    private static int totalHours;

    @BeforeClass
    public static void setUpOnce() {
        System.out.println("+++ setUpOnce +++");

        // Arrange
        wController = WeatherController.getInstance();
        totalHours = wController.getTotalHours();
        hourlyTemperatures = new double[totalHours];

        for (int i = 0; i < totalHours; i++) {
            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDownOnce() {
        System.out.println("+++ tearDownOnce +++");

        if (wController != null) {
            wController.close();
        }
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s224658749";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Durga Reddy Kankanala";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Arrange
        double minTemperature = hourlyTemperatures[0];
        for (int i = 1; i < totalHours; i++) {
            if (hourlyTemperatures[i] < minTemperature) {
                minTemperature = hourlyTemperatures[i];
            }
        }

        // Act
        double cachedMin = wController.getTemperatureMinFromCache();

        // Assert
        Assert.assertEquals(minTemperature, cachedMin, 0.0001);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Arrange
        double maxTemperature = hourlyTemperatures[0];
        for (int i = 1; i < totalHours; i++) {
            if (hourlyTemperatures[i] > maxTemperature) {
                maxTemperature = hourlyTemperatures[i];
            }
        }

        // Act
        double cachedMax = wController.getTemperatureMaxFromCache();

        // Assert
        Assert.assertEquals(maxTemperature, cachedMax, 0.0001);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Arrange
        double sumTemp = 0;
        for (int i = 0; i < totalHours; i++) {
            sumTemp += hourlyTemperatures[i];
        }
        double averageTemp = sumTemp / totalHours;

        // Act
        double cachedAverage = wController.getTemperatureAverageFromCache();

        // Assert
        Assert.assertEquals(averageTemp, cachedAverage, 0.0001);
    }

    @Test
    public void testTemperaturePersist() {
     
    }
}
