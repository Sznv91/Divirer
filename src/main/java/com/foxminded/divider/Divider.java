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
		int currentIncompleteQuotient = 0;
		int currentRemainder = 0;
		int partOfResult = 0;
		int result = 0;
		for (int i = 0; i < dividendMassive.length; i++) {
			if (currentIncompleteQuotient / divider == 0) {
				currentIncompleteQuotient = appendDigits(currentIncompleteQuotient, dividendMassive[i]);
				if (result != 0) {
					result = appendDigits(result, 0);
					incompleteQuotientArray.add(0);
					remainderArray.add(0);
				}
			} else {
				incompleteQuotientArray.add(currentIncompleteQuotient);
				partOfResult = currentIncompleteQuotient / divider;
				currentRemainder = partOfResult * divider;
				remainderArray.add(currentRemainder);
				result = appendDigits(result, partOfResult);
				currentIncompleteQuotient = currentIncompleteQuotient - currentRemainder;
				currentIncompleteQuotient = appendDigits(currentIncompleteQuotient, dividendMassive[i]);
			}
		}
		// last iteration//
		partOfResult = currentIncompleteQuotient / divider;
		result = appendDigits(result, partOfResult);
		currentRemainder = partOfResult * divider;
		incompleteQuotientArray.add(currentIncompleteQuotient);
		remainderArray.add(currentRemainder);
		incompleteQuotientArray.add(currentIncompleteQuotient - currentRemainder);

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

	protected static Integer howManyDigit(int number) {
		if (number == 0) {
			return 1;
		}
		int result = 0;
		while (number > 0) {
			number = number / 10;
			result++;
		}
		return result;
	}

	private Integer appendDigits(int appended, int add) {
		if (appended == 0) {
			return add;
		}
		int multipler = 1;
		int result = 0;
		int counter = howManyDigit(add);
		while (counter != 0) {
			result += getDigit(add, counter) * multipler;
			counter--;
			multipler = multipler * 10;
		}
		counter = howManyDigit(appended);
		while (counter != 0) {
			result += getDigit(appended, counter) * multipler;
			counter--;
			multipler = multipler * 10;
		}
		return result;
	}

}