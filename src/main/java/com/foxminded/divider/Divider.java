package com.foxminded.divider;

public class Divider {
	
	public int[][] divide(int dividend, int divider) {
		int[] numbersOfDividend = makeNumMassive(dividend, divider);
		int[][] result = calcResult(numbersOfDividend, divider);
		return result;
	}

	private Integer findAnswerDigit(int dividend, int divider) {
		int result = 9;
		while (true) {
			if (dividend - (divider * result) >= 0) {
				return result;
			} else {
				result--;
			}
		}
	}

	private int[] makeNumMassive(int dividend, int divider) {
		int firstCell = getDigit(dividend, 1);
		int counter = 1;
		for (int i = 2; i <= howManyDigit(dividend); i++) {
			if (firstCell / divider > 0) {
				break;
			} else {
				firstCell = appendDigits(firstCell, getDigit(dividend, i));
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

	private int[][] calcResult(int[] numbersOfDividend, int divider) {
		int[][] result = new int [4][numbersOfDividend.length];
		result[0] = numbersOfDividend;
		int lastValue = 0;
		for (int i = 0; i < result[0].length; i++) {
			lastValue = appendDigits(lastValue, numbersOfDividend[i]);
			result [2][i] = lastValue; //top number
			result[1][i] = findAnswerDigit(lastValue, divider); //answer
			result[3][i] = result[1][i] * divider; //bottom number
			lastValue = lastValue - result[3][i];
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

	private Integer appendDigits(int firstDigit, int secondDigit) {
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