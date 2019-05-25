package com.foxminded.divider;

public class Divider {

	public int[] divide(int dividend, int divider) {
		int[] numbersOfDividend = makeNumMassive(dividend, divider);
		int[] result = calcResult(numbersOfDividend, divider);
		return result;
	}

	private Integer findingAnswerCell(int dividend, int divider) {
		int result = 9;
		while (true) {
			if (dividend - (divider * result) >= 0) {
				return result;
			} else {
				result--;
			}
		}
	}

	protected int[] makeNumMassive(int dividend, int divider) {
		int firstCell = getDigit(dividend, 1);
		int counter = 1;
		for (int i = 2; i <= howManyDigit(dividend); i++) {
			if (firstCell / divider > 0) {
				break;
			} else {
				firstCell = joiningDigits(firstCell, getDigit(dividend, i));
				counter++;
			}
		}
		int[] numbersOfDividend = new int[howManyDigit(dividend) - howManyDigit(firstCell) + 1];
		numbersOfDividend[0] = firstCell;
		for (int i = 1; i < numbersOfDividend.length; i++) {
			numbersOfDividend[i] = getDigit(dividend, counter + 1);
			counter++;
		}
		return numbersOfDividend;
	}

	private int[] calcResult(int[] numbersOfDividend, int divider) {
		int[] result = new int [numbersOfDividend.length];
		int lastValue = 0;
		for (int i = 0; i < numbersOfDividend.length; i++) {
			lastValue = joiningDigits(lastValue, numbersOfDividend[i]);
			int answerCell = findingAnswerCell(lastValue, divider);
			result[i] = answerCell;
			lastValue = lastValue - (answerCell * divider);
		}

		return result;
	}

	private Integer getDigit(int numeric, int position) {
		int counter = 1;
		int multipler = 1;
		int result = 0;
		for (int i = 1; i < howManyDigit(numeric); i++) {
			multipler = multipler * 10;
		}
		while (counter <= position) {
			if (counter == position) {
				result = numeric / multipler;
				break;
			} else {
				numeric = numeric - ((numeric / multipler) * multipler);
				multipler = multipler / 10;
				counter++;
			}
		}
		return result;
	}

	private Integer howManyDigit(int numeric) {
		if (numeric == 0) {
			return 1;
		}
		int result = 0;
		while (numeric > 0) {
			numeric = numeric / 10;
			result++;
		}
		return result;
	}

	private Integer joiningDigits(int firstDigit, int secondDigit) {
		if (firstDigit == 0) {
			return secondDigit;
		}
		int multipler = 1;
		int result = 0;
		int counter = howManyDigit(secondDigit);
		while (counter != 0) {
			result += getDigit(secondDigit, counter) * multipler;
			counter--;
			multipler = multipler * 10;
		}
		counter = howManyDigit(firstDigit);
		while (counter != 0) {
			result += getDigit(firstDigit, counter) * multipler;
			counter--;
			multipler = multipler * 10;
		}
		return result;
	}
}