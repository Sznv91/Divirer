package com.foxminded.divider;

import java.util.ArrayList;

public class DivisionFormatter {

	public String format(DivisionResult answer) {
		int divider = answer.getDivider();
		int[] dividend = answer.getDividendMassive();
		ArrayList<Integer> ans = answer.getAnswer();
		ArrayList<Integer> upper = answer.getUpperResults();
		ArrayList<Integer> down = answer.getDownerResults();
		StringBuilder result = new StringBuilder();

		formatFirstString(dividend, divider, result);
		formatSecondString(dividend.length, divider, result, ans, down);
		formatThirdString(dividend, result, ans);
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

	private void formatSecondString(int dividendLengh, int divider, StringBuilder result, ArrayList<Integer> answer,
			ArrayList<Integer> downder) {
		StringBuilder secondString = new StringBuilder();
		secondString.append(" " + downder.get(0));
		while (secondString.length() < dividendLengh + 1) {
			secondString.append(" ");
		}
		secondString.append("|");
		for (int i = 0; i < answer.size(); i++) {
			secondString.append("-");
		}
		result.append(secondString.toString() + System.lineSeparator());
	}

	private void formatThirdString(int[] dividend, StringBuilder result, ArrayList<Integer> answer) {
		StringBuilder thirdString = new StringBuilder();
		thirdString.append(" ");
		int numberOfDigits = 0;
		for (int i = 0; i < dividend.length - 1; i++) {
			numberOfDigits += howManyDigit(dividend[i]);
		}
		for (int i = 0; i <= numberOfDigits; i++) {
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

	private void formatOtherString(StringBuilder result, ArrayList<Integer> upString, ArrayList<Integer> downString) {
		StringBuilder otherString;
		int lastLenghSting = howManyDigit(upString.get(0)) + 1;
		System.out.println (lastLenghSting + " first element up string array36925814");
		for (int i = 1; i < downString.size(); i++) {
			otherString = new StringBuilder();
			otherString.append("_" + upString.get(i));
			while (otherString.length() != lastLenghSting + 1) {
				otherString.insert(0, " ");
			}
			lastLenghSting = otherString.length();
			if(downString.get(i).equals(0)) {
				continue;
			}
			result.append(otherString.toString() + System.lineSeparator());
			otherString = new StringBuilder();
			otherString.append(downString.get(i));
			while (otherString.length() != lastLenghSting) {
				otherString.insert(0, " ");
			}
			otherString.append(System.lineSeparator());
			otherString.append(getBottomLine(upString.get(i), otherString));
			result.append(otherString.toString() + System.lineSeparator());
		}
		otherString = new StringBuilder();
		otherString.append(upString.get(upString.size() - 1));
		while (otherString.length() < lastLenghSting) {
			otherString.insert(0, " ");
		}
		result.append(otherString);
	}

	private String getBottomLine(int lastNumber, StringBuilder printedString) {
		StringBuilder bottomLine = new StringBuilder();
		while (howManyDigit(lastNumber) > bottomLine.length()) {
			bottomLine.append("-");
		}
		while (printedString.length() - 2 > bottomLine.length()) {
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
