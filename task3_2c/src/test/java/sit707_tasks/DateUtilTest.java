package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Equivalence class testing for DateUtil
 */
public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224658749";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Durga Reddy Kankanala";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("testMaxJanuary31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("testMaxJanuary31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);

        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);

        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // D1: day 1-28, M2: 31-day month, Y1: leap year
    @Test
    public void testDayBetween1And28In31DayMonth() {
        DateUtil date = new DateUtil(15, 3, 2024);
        System.out.println("testDayBetween1And28In31DayMonth > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // D2: day 29, M1: 30-day month, Y2: non-leap year
    @Test
    public void testDay29In30DayMonth() {
        DateUtil date = new DateUtil(29, 4, 2023);
        System.out.println("testDay29In30DayMonth > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // D3: day 30, M1: 30-day month
    @Test
    public void testDay30In30DayMonthShouldGoToNextMonth() {
        DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("testDay30In30DayMonthShouldGoToNextMonth > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // D3: day 30, M2: 31-day month
    @Test
    public void testDay30In31DayMonthShouldGoTo31() {
        DateUtil date = new DateUtil(30, 1, 2024);
        System.out.println("testDay30In31DayMonthShouldGoTo31 > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // D4: day 31, M2: 31-day month
    @Test
    public void testDay31In31DayMonthShouldGoToNextMonth() {
        DateUtil date = new DateUtil(31, 5, 2024);
        System.out.println("testDay31In31DayMonthShouldGoToNextMonth > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // February in non-leap year
    @Test
    public void testFebruary28InNonLeapYear() {
        DateUtil date = new DateUtil(28, 2, 2023);
        System.out.println("testFebruary28InNonLeapYear > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // February in leap year
    @Test
    public void testFebruary28InLeapYear() {
        DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("testFebruary28InLeapYear > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // February 29 in leap year
    @Test
    public void testFebruary29InLeapYear() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("testFebruary29InLeapYear > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMarch1InLeapYearShouldGoBackToFebruary29() {
        DateUtil date = new DateUtil(1, 3, 2024);
        System.out.println("testMarch1InLeapYearShouldGoBackToFebruary29 > " + date);
        date.decrement();
        System.out.println(date);

        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMarch1InNonLeapYearShouldGoBackToFebruary28() {
        DateUtil date = new DateUtil(1, 3, 2023);
        System.out.println("testMarch1InNonLeapYearShouldGoBackToFebruary28 > " + date);
        date.decrement();
        System.out.println(date);

        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testDecember31ShouldGoToJanuary1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2023);
        System.out.println("testDecember31ShouldGoToJanuary1NextYear > " + date);
        date.increment();
        System.out.println(date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testJanuary1ShouldGoToDecember31PreviousYear() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testJanuary1ShouldGoToDecember31PreviousYear > " + date);
        date.decrement();
        System.out.println(date);

        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
}