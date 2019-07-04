package com.foxminded.divider;

import java.util.ArrayList;
import java.util.List;
import static com.foxminded.divider.NumberUtils.*;

public class Divider {

	public DivisionResult divide(int dividend, int divider) {
		DivisionResult divisionResult = new DivisionResult(dividend, divider);
//		List<Integer> incompleteQuotient = new ArrayList<>();
//		List<Integer> remainder = new ArrayList<>();
		int incompleteQuotient;
		int remainder;
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
//					incompleteQuotient.add(0);
//					remainder.add(0);
					divisionResult.setIncompleteQuotientAndRemainder(0, 0);					
				}
			} else {
//				incompleteQuotient.add(currentIncompleteQuotient);
				partOfResult = currentIncompleteQuotient / divider;
				currentRemainder = partOfResult * divider;
//				remainder.add(currentRemainder);
				divisionResult.setIncompleteQuotientAndRemainder(currentIncompleteQuotient, currentRemainder);
				result = appendDigits(result, partOfResult);
				currentIncompleteQuotient = currentIncompleteQuotient - currentRemainder;
				currentIncompleteQuotient = appendDigits(currentIncompleteQuotient, currentDividendDigit);
			}
		}
		partOfResult = currentIncompleteQuotient / divider;
		result = appendDigits(result, partOfResult);
		currentRemainder = partOfResult * divider;
//		incompleteQuotient.add(currentIncompleteQuotient);
//		remainder.add(currentRemainder);
		divisionResult.setIncompleteQuotientAndRemainder(currentIncompleteQuotient, currentRemainder);
//		incompleteQuotient.add(currentIncompleteQuotient - currentRemainder);
		divisionResult.setIncompleteQuotientAndRemainder(currentIncompleteQuotient-currentRemainder, 0);
		divisionResult.setResult(result);
//		divisionResult.setIncompleteQuotient(incompleteQuotient);
//		divisionResult.setRemainder(remainder);
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