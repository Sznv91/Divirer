package com.foxminded.divider;

import java.util.ArrayList;

public class Divider {

	public DivisionResult getResult(int dividend, int divider) {
		DivisionResult result = new DivisionResult(dividend, divider);
		divide(result);
		return result;
	}

	private DivisionResult divide(DivisionResult divisionResult) {
		int dividend = divisionResult.getDivident();
		int divider = divisionResult.getDivider();
		int[] dividendMassive = new int[howManyDigit(dividend)];
		for (int i = 0; i < dividendMassive.length; i++) {
			dividendMassive[i] = getDigit(dividend, i + 1);
		}
		ArrayList<Integer> incompleteQuotientArray = new ArrayList<Integer>();
		ArrayList<Integer> remainderArray = new ArrayList<Integer>();
		int incompleteQuotient = 0;
		int remainder = 0;
		int partOfResult = 0;
		int result = 0;
		for (int i = 0; i < dividendMassive.length; i++) {
			if (incompleteQuotient / divider == 0) {
				incompleteQuotient = appendDigits(incompleteQuotient, dividendMassive[i]);
				if (result != 0) {
					result = appendDigits(result, 0);
					incompleteQuotientArray.add(0);
					remainderArray.add(0);
				}
			} else {
				incompleteQuotientArray.add(incompleteQuotient);
				partOfResult = incompleteQuotient / divider;
				remainder = partOfResult * divider;
				remainderArray.add(remainder);
				result = appendDigits(result, partOfResult);
				incompleteQuotient = incompleteQuotient - remainder;
				incompleteQuotient = appendDigits(incompleteQuotient, dividendMassive[i]);
			}
		}
		// last iteration//
		partOfResult = incompleteQuotient / divider;
		result = appendDigits(result, partOfResult);
		remainder = partOfResult * divider;
		incompleteQuotientArray.add(incompleteQuotient);
		remainderArray.add(remainder);
		incompleteQuotientArray.add(incompleteQuotient - remainder);

		divisionResult.setResult(result);
		divisionResult.setIncompleteQuotient(incompleteQuotientArray);
		divisionResult.setRemainder(remainderArray);
		return divisionResult;
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

	protected static Integer howManyDigit(int numeric) {
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