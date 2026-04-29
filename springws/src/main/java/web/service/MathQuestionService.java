package web.service;

public class MathQuestionService {

	public static double q1Addition(String number1, String number2) {
		if (!isValidNumber(number1) || !isValidNumber(number2)) {
			return Double.NaN;
		}
		return Double.valueOf(number1) + Double.valueOf(number2);
	}

	public static double q2Subtraction(String number1, String number2) {
		if (!isValidNumber(number1) || !isValidNumber(number2)) {
			return Double.NaN;
		}
		return Double.valueOf(number1) - Double.valueOf(number2);
	}

	public static double q3Multiplication(String number1, String number2) {
		if (!isValidNumber(number1) || !isValidNumber(number2)) {
			return Double.NaN;
		}
		return Double.valueOf(number1) * Double.valueOf(number2);
	}

	public static boolean isCorrectAnswer(double correctAnswer, String userAnswer) {
		if (Double.isNaN(correctAnswer) || !isValidNumber(userAnswer)) {
			return false;
		}
		return correctAnswer == Double.valueOf(userAnswer);
	}

	private static boolean isValidNumber(String value) {
		if (value == null || value.trim().isEmpty()) {
			return false;
		}

		try {
			Double.valueOf(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}