package com.foxminded.divider;

import static com.foxminded.divider.NumberUtils.*;

public class Divider {

	public DivisionResult divide(int dividend, int divider) {
		DivisionResult divisionResult = new DivisionResult(dividend, divider);
		int[] dividendDigits = decomposeDividend(dividend);
		int incompleteQuotient = 0;
		int remainder = 0;
		int partOfResult = 0;
		int result = 0;
		for (int digit : dividendDigits) {
			if (incompleteQuotient / divider == 0) {
				incompleteQuotient = appendDigits(incompleteQuotient, digit);
				if (result != 0) {
					result = appendDigits(result, 0);
					divisionResult.setDivisionStep(0, 0);
				}
			} else {
				partOfResult = incompleteQuotient / divider;
				remainder = partOfResult * divider;
				divisionResult.setDivisionStep(incompleteQuotient, remainder);
				result = appendDigits(result, partOfResult);
				incompleteQuotient = incompleteQuotient - remainder;
				incompleteQuotient = appendDigits(incompleteQuotient, digit);
			}
		}
		partOfResult = incompleteQuotient / divider;
		result = appendDigits(result, partOfResult);
		remainder = partOfResult * divider;
		divisionResult.setDivisionStep(incompleteQuotient, remainder);
		divisionResult.setDivisionStep(incompleteQuotient - remainder, 0);
		divisionResult.setResult(result);
		return divisionResult;
	}

}