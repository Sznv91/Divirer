package com.foxminded.divider;

import java.util.List;

import static com.foxminded.divider.NumberUtils.howManyDigit;

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
		List<DivisionStep> stepsDigit = divisionResult.getStepsDigit();
		result.append("_" + dividend + "|" + divider + System.lineSeparator());

		StringBuilder secondString = new StringBuilder();
		secondString.append(" " + stepsDigit.get(0).getRemainder());
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
			if (i < howManyDigit(stepsDigit.get(0).getIncompleteQuotient())) {
				thirdString.append("-");
			} else {
				thirdString.append(" ");
			}
		}
		thirdString.append("|" + divideResult);
		result.append(thirdString.toString() + System.lineSeparator());
	}

	private void formatSteps(StringBuilder result, DivisionResult divisionResult) {
		List<DivisionStep> stepsDigit = divisionResult.getStepsDigit();
		StringBuilder otherString;
		int lengthLastString = howManyDigit(stepsDigit.get(0).getIncompleteQuotient()) + 1;
		for (int i = 1; i < stepsDigit.size() - 1; i++) {
			otherString = new StringBuilder();
			otherString.append("_" + stepsDigit.get(i).getIncompleteQuotient());
			while (otherString.length() != lengthLastString + 1) {
				otherString.insert(0, " ");
			}
			lengthLastString = otherString.length();
			if (stepsDigit.get(i).getRemainder() == 0) {
				continue;
			}
			result.append(otherString.toString() + System.lineSeparator());
			otherString = new StringBuilder();
			otherString.append(stepsDigit.get(i).getRemainder());
			while (otherString.length() != lengthLastString) {
				otherString.insert(0, " ");
			}
			otherString.append(System.lineSeparator());
			otherString.append(getLineSubtract(stepsDigit.get(i).getIncompleteQuotient(), otherString));
			result.append(otherString.toString() + System.lineSeparator());
		}
	}

	private void formatRemainder(StringBuilder result, DivisionResult divisionResult) {
		List<DivisionStep> stepsDigit = divisionResult.getStepsDigit();
		int dividend = divisionResult.getDivident();
		StringBuilder lastString = new StringBuilder();
		lastString.append(stepsDigit.get(stepsDigit.size() - 1).getIncompleteQuotient());
		while (lastString.length() < howManyDigit(dividend) + 1) {
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
