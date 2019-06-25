package com.foxminded.divider;

import java.util.List;

import static com.foxminded.divider.Divider.howManyDigit;;

public class DivisionFormatter {

	public String format(DivisionResult divisionResult) {
		int divider = divisionResult.getDivider();
		int dividend = divisionResult.getDivident();
		int resultDivider = divisionResult.getResult();
		List<Integer> incompleteQuotient = divisionResult.getIncompleteQuotient();
		List<Integer> remainder = divisionResult.getRemainder();
		StringBuilder result = new StringBuilder();

		formatHeader(dividend, divider, result, resultDivider, remainder);
		formatThirdString(dividend, result, resultDivider, incompleteQuotient);
		formatOtherString(result, incompleteQuotient, remainder);
		return result.toString();
	}

	private void formatHeader(int dividend, int divider, StringBuilder result, int answer,
			List<Integer> remainder) {
		StringBuilder firstString = new StringBuilder("_" + dividend);
		firstString.append("|" + divider);
		result.append(firstString.toString() + System.lineSeparator());
		
		StringBuilder secondString = new StringBuilder();
		secondString.append(" " + remainder.get(0));
		while (secondString.length() < howManyDigit(dividend) + 1) {
			secondString.append(" ");
		}
		secondString.append("|");
		for (int i = 0; i < howManyDigit(answer); i++) {
			secondString.append("-");
		}
		result.append(secondString.toString() + System.lineSeparator());
	}

	private void formatThirdString(int dividend, StringBuilder result, int answer,
			List<Integer> incompleteQuotient) {
		StringBuilder thirdString = new StringBuilder();
		thirdString.append(" ");
		for (int i = 0; i < howManyDigit(dividend); i++) {
			if (i < howManyDigit(incompleteQuotient.get(0))) {
				thirdString.append("-");
			} else {
				thirdString.append(" ");
			}
		}
		thirdString.append("|" + answer);
		result.append(thirdString.toString() + System.lineSeparator());
	}

	private void formatOtherString(StringBuilder result, List<Integer> incompleteQuotient, List<Integer> remainder) {
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
		otherString = new StringBuilder();
		otherString.append(incompleteQuotient.get(incompleteQuotient.size() - 1));
		while (otherString.length() < lengthLastString) {
			otherString.insert(0, " ");
		}
		result.append(otherString);
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
