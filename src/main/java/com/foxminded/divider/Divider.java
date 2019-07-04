package com.foxminded.divider;

import static com.foxminded.divider.NumberUtils.*;

public class Divider {

	public DivisionResult divide(int dividend, int divider) {
		DivisionResult divisionResult = new DivisionResult(dividend, divider);
		int[] dividendDigits = decomposeDividend(dividend);
		int currentIncompleteQuotient = 0;
		int currentRemainder = 0;
		int partOfResult = 0;
		int result = 0;
		for (int currentDividendDigit : dividendDigits) {
			if (currentIncompleteQuotient / divider == 0) {
				currentIncompleteQuotient = appendDigits(currentIncompleteQuotient, currentDividendDigit);
				if (result != 0) {
					result = appendDigits(result, 0);
					divisionResult.setIncompleteQuotientAndRemainder(0, 0);					
				}
			} else {
				partOfResult = currentIncompleteQuotient / divider;
				currentRemainder = partOfResult * divider;
				divisionResult.setIncompleteQuotientAndRemainder(currentIncompleteQuotient, currentRemainder);
				result = appendDigits(result, partOfResult);
				currentIncompleteQuotient = currentIncompleteQuotient - currentRemainder;
				currentIncompleteQuotient = appendDigits(currentIncompleteQuotient, currentDividendDigit);
			}
		}
		partOfResult = currentIncompleteQuotient / divider;
		result = appendDigits(result, partOfResult);
		currentRemainder = partOfResult * divider;
		divisionResult.setIncompleteQuotientAndRemainder(currentIncompleteQuotient, currentRemainder);
		divisionResult.setIncompleteQuotientAndRemainder(currentIncompleteQuotient-currentRemainder, 0);
		divisionResult.setResult(result);
		return divisionResult;
	}

	private int[] decomposeDividend(int dividend) {
		int[] result = new int[howManyDigit(dividend)];
		for (int i = 0; i < result.length; i++) {
			result[i] = getDigit(dividend, i + 1);
		}
		return result;
	}

}