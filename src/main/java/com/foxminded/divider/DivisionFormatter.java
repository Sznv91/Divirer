package com.foxminded.divider;

import java.util.List;

import static com.foxminded.divider.Divider.howManyDigit;;

public class DivisionFormatter {

	public String format(DivisionResult divisionResult) {
		StringBuilder result = new StringBuilder();
		formatHeader(result, divisionResult);
		formatSteps(result, divisionResult);
		formatRemainder(result, divisionResult);
		return result.toString();
	}

	private void formatHeader(StringBuilder result, DivisionResult divisionResult) {
		int dividend = divisionResult.getDivident(); 
		int divider = divisionResult.getDivider(); 
		int divideResult = divisionResult.getResult();
		List<Integer> remainder = divisionResult.getRemainder();
		List<Integer> incompleteQuotient = divisionResult.getIncompleteQuotient();
		StringBuilder firstString = new StringBuilder("_" + dividend);
		firstString.append("|" + divider);
		result.append(firstString.toString() + System.lineSeparator());
		
		StringBuilder secondString = new StringBuilder();
		secondString.append(" " + remainder.get(0));
		while (secondString.length() < howManyDigit(dividend) + 1) {
			secondString.append(" ");
		}
		secondString.append("|");
		for (int i = 0; i < howManyDigit(divideResult); i++) {
			secondString.append("-");
		}
		result.append(secondString.toString() + System.lineSeparator());
		StringBuilder thirdString = new StringBuilder();
		thirdString.append(" ");
		for (int i = 0; i < howManyDigit(dividend); i++) {
			if (i < howManyDigit(incompleteQuotient.get(0))) {
				thirdString.append("-");
			} else {
				thirdString.append(" ");
			}
		}
		thirdString.append("|" + divideResult);
		result.append(thirdString.toString() + System.lineSeparator());
	}

	private void formatSteps(StringBuilder result, DivisionResult divisionResult) {
		List<Integer> incompleteQuotient = divisionResult.getIncompleteQuotient();
		List<Integer> remainder = divisionResult.getRemainder();
		StringBuilder otherString;
		int lengthLastString = howManyDigit(incompleteQuotient.get(0)) + 1;
		for (int i = 1; i < remainder.size(); i++) {
			otherString = new StringBuilder();
			otherString.append("_" + incompleteQuotient.get(i));
			while (otherString.length() != lengthLastString + 1) {
				otherString.insert(0, " ");
			}
			lengthLastString = otherString.length();
			if (remainder.get(i).equals(0)) {
				continue;
			}
			result.append(otherString.toString() + System.lineSeparator());
			otherString = new StringBuilder();
			otherString.append(remainder.get(i));
			while (otherString.length() != lengthLastString) {
				otherString.insert(0, " ");
			}
			otherString.append(System.lineSeparator());
			otherString.append(getLineSubtract(incompleteQuotient.get(i), otherString));
			result.append(otherString.toString() + System.lineSeparator());
		}
	}
	
	private void formatRemainder (StringBuilder result, DivisionResult divisionResult) {
		List<Integer> incompleteQuotient = divisionResult.getIncompleteQuotient();
		int dividend = divisionResult.getDivident();
		StringBuilder lastString = new StringBuilder();
		lastString.append(incompleteQuotient.get(incompleteQuotient.size() - 1));
		while (lastString.length() < howManyDigit(dividend)+1) {
			lastString.insert(0, " ");
		}
		result.append(lastString);
	}

	private String getLineSubtract(int number, StringBuilder lastAppendString) {
		StringBuilder line = new StringBuilder();
		while (howManyDigit(number) > line.length()) {
			line.append("-");
		}
		while (lastAppendString.length() - 2 > line.length()) {
			line.insert(0, " ");
		}
		return line.toString();
	}

}
