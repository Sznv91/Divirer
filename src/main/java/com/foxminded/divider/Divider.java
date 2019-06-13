package com.foxminded.divider;

public class Divider {

	private DivisionResult result;

	public DivisionResult getResult(int dividend, int divider) {
		int[] numbersOfDividend = prepareMassive(dividend, divider);
		result = new DivisionResult(numbersOfDividend, divider);
		divide(result);
		return result;
	}

	private int[] prepareMassive(int dividend, int divider) {
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

	private void divide(DivisionResult result) {
		int[] dividendMassiv = result.getDivident();
		int[] upperDigits = new int[dividendMassiv.length + 1];
		int[] downDigits = new int[dividendMassiv.length];
		int divider = result.getDivider();
		int upperDivedend = 0;
		int[] answer = new int[dividendMassiv.length];
		for (int i = 0; i < dividendMassiv.length; i++) {
			upperDivedend = appendDigits(upperDivedend, dividendMassiv[i]);
			upperDigits[i] = upperDivedend;
			answer[i] = findAnswerDigit(upperDivedend, divider);
			int downerDivident = answer[i] * divider;
			downDigits[i] = downerDivident;
			if (i == dividendMassiv.length - 1) {
				upperDigits[i + 1] = upperDivedend - downerDivident;
			}
			upperDivedend = upperDivedend - downerDivident;
		}
		result.setAnswer(answer);
		result.setUpperResults(upperDigits);
		result.setDownerResults(downDigits);
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