package com.foxminded.divider;

import java.util.ArrayList;

public class DivisionFormatter {

	public String format(DivisionResult answer) {
		int divider = answer.getDivider();
		int[] dividend = answer.getDivident();
		int[] ans = answer.getAnswer();
		int[] upper = answer.getUpperResults();
		int[] down = answer.getDownerResults();
		StringBuilder result = new StringBuilder();

		formatFirstString(dividend, divider, result);
		formatSecondString(dividend.length, divider, result, ans, down);
		formatThirdString(dividend, divider, result, ans);
		formatOtherString(result, upper, down);
		return result.toString();
	}

	private void formatFirstString(int[] dividend, int divider, StringBuilder result) {
		StringBuilder firstString = new StringBuilder("_");
		for (int digit : dividend) {
			firstString.append(digit);
		}
		firstString.append("|" + divider);
		result.append(firstString.toString() + System.lineSeparator());
	}

	private void formatSecondString(int dividendLengh, int divider, StringBuilder result, int[] answer, int[] downder) {
		StringBuilder secondString = new StringBuilder();
		secondString.append(" " + downder[0]);
		for (int i = 0; i < dividendLengh - 1; i++) {
			secondString.append(" ");
		}
		secondString.append("|");
		for (int i = 0; i < answer.length; i++) {
			secondString.append("-");
		}
		result.append(secondString.toString() + System.lineSeparator());
	}

	private void formatThirdString(int[] dividend, int divider, StringBuilder result, int[] answer) {
		StringBuilder thirdString = new StringBuilder();
		thirdString.append(" ");
		for (int i = 0; i <= dividend.length + 1; i++) {
			if (i < howManyDigit(dividend[0])) {
				thirdString.append("-");
			} else {
				thirdString.append(" ");
			}
		}
		thirdString.append("|");
		for (int i : answer) {
			thirdString.append(i);
		}
		result.append(thirdString.toString() + System.lineSeparator());
	}

	private void formatOtherString(StringBuilder result, int[] upString, int[] downString) {
		StringBuilder otherString;
		int lastLenghSting = howManyDigit(upString[0]) + 1;
		for (int i = 1; i < downString.length; i++) {
			otherString = new StringBuilder();
			otherString.append(upString[i]);
			while (otherString.length() != lastLenghSting + 1) {
				otherString.insert(0, " ");
			}
			lastLenghSting = otherString.length();
			result.append(otherString.toString() + System.lineSeparator());
			otherString = new StringBuilder();
			otherString.append(downString[i]);
			while (otherString.length() != lastLenghSting) {
				otherString.insert(0, " ");
			}
			otherString.append(System.lineSeparator());
			otherString.append(getBottomLine(upString[i], otherString)); // GET BUTTOM LINE
			result.append(otherString.toString() + System.lineSeparator());

		}
	}

	private String getLastString(int[][] dividendMassive, int lastLenghString) {
		StringBuilder lastString = new StringBuilder();
		int lastNumber = dividendMassive[2][dividendMassive[2].length - 1]
				- dividendMassive[3][dividendMassive[3].length - 1];
		lastString.append(lastNumber);
		while (lastString.length() <= lastLenghString) {
			lastString.insert(0, " ");
		}
		return lastString.toString();
	}

	private String getBottomLine(int lastNumber, StringBuilder printedString) {
		StringBuilder bottomLine = new StringBuilder();
		while (howManyDigit(lastNumber) > bottomLine.length()) {
			bottomLine.append("-");
		}
		while (printedString.length()-2 > bottomLine.length()) {
			bottomLine.insert(0, " ");
		}
		return bottomLine.toString();
	}

	private int howManyDigit(int num) {
		int counter = 0;
		if (num == 0) {
			return 1;
		}
		while (num > 0) {
			num = num / 10;
			counter++;
		}
		return counter;
	}

}