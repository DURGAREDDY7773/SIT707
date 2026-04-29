package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	@Test
	public void testQ1AdditionCorrect() {
		Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
	}

	@Test
	public void testQ1AdditionWithEmptyInput() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "2")));
	}

	@Test
	public void testQ2SubtractionCorrect() {
		Assert.assertEquals(5.0, MathQuestionService.q2Subtraction("10", "5"), 0);
	}

	@Test
	public void testQ2SubtractionWithInvalidInput() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("abc", "5")));
	}

	@Test
	public void testQ3MultiplicationCorrect() {
		Assert.assertEquals(20.0, MathQuestionService.q3Multiplication("4", "5"), 0);
	}

	@Test
	public void testQ3MultiplicationWithEmptyInput() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("4", "")));
	}

	@Test
	public void testCorrectAnswerTrue() {
		Assert.assertTrue(MathQuestionService.isCorrectAnswer(10.0, "10"));
	}

	@Test
	public void testCorrectAnswerFalse() {
		Assert.assertFalse(MathQuestionService.isCorrectAnswer(10.0, "9"));
	}

	@Test
	public void testCorrectAnswerWithEmptyInput() {
		Assert.assertFalse(MathQuestionService.isCorrectAnswer(10.0, ""));
	}
}