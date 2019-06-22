package com.foxminded.divider;

import java.util.ArrayList;

public class Divider {

	public DivisionResult getResult(int dividend, int divider) {
		DivisionResult result = new DivisionResult(dividend, divider);
		divide(result);
		return result;
	}

	private DivisionResult divide(DivisionResult result) {
		int dividend = result.getDivident();
		int divider = result.getDivider();
		int[] dividendMassive = new int[howManyDigit(dividend)];
		for (int i = 0; i < dividendMassive.length; i++) {
			dividendMassive[i] = getDigit(dividend, i + 1);
		}
		ArrayList<Integer> upResultArray = new ArrayList<Integer>();
		ArrayList<Integer> downResultArray = new ArrayList<Integer>();
		int upResult = 0;
		int answer = 0;
		for (int i = 0; i < dividendMassive.length; i++) {
			if (upResult / divider == 0) {
				upResult = appendDigits(upResult, dividendMassive[i]);
				if (answer != 0) {
					answer = appendDigits(answer, 0);
					upResultArray.add(0);
					downResultArray.add(0);
				}
			} else {
				upResultArray.add(upResult);
				int partOfAnswer = upResult / divider;
				int downResult = partOfAnswer * divider;
				downResultArray.add(downResult);
				answer = appendDigits(answer, partOfAnswer);
				upResult = upResult - downResult;
				upResult = appendDigits(upResult, dividendMassive[i]);
				if (i == dividendMassive.length - 1) {
					partOfAnswer = upResult / divider;
					answer = appendDigits(answer, partOfAnswer);
					downResult = partOfAnswer * divider;
					upResultArray.add(upResult);
					downResultArray.add(downResult);
					upResultArray.add(upResult - downResult);
				}
			}
		}
		result.setDividendMassive(dividendMassive);
		result.setAnswer(answer);
		result.setUpperResults(upResultArray);
		result.setDownerResults(downResultArray);
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