package com.foxminded.divider;

import java.util.ArrayList;

public class DivisionFormatter {

	private static int dividend, divider;
	private static int[] answer;
	private static int[] dividendMassive;
	private ArrayList<String> result = new ArrayList<String>();

	public ArrayList<String> format(int dividend, int divider) {
		Divider dividerInstanse = new Divider();
		this.dividend = dividend;
		this.divider = divider;
		this.answer = dividerInstanse.divide(dividend, divider);
		this.dividendMassive = dividerInstanse.getNumbersOfDividend();

		formatFirstString();
		formatSecondString();
		formatThirdString();
		formatOtherString();
		return result;

	}

	private void formatFirstString() {
		StringBuilder firstString = new StringBuilder("_");
		firstString.append(dividend + "|" + divider);
		result.add(firstString.toString());
	}

	private void formatSecondString() {
		StringBuilder secondString = new StringBuilder();
		secondString.append(" " + divider * answer[0]);
		for (int i = 0; i < dividendMassive.length - 1; i++) {
			secondString.append(" ");
		}
		secondString.append("|");
		for (int i = 0; i < answer.length; i++) {
			secondString.append("-");
		}
		result.add(secondString.toString());
	}

	private void formatThirdString() {
		StringBuilder thirdString = new StringBuilder();
		thirdString.append(" ");
		for (int i = 0; i < howManyDigit(dividend); i++) {
			if (i < howManyDigit(answer[0] * divider)) {
				thirdString.append("-");
			} else {
				thirdString.append(" ");
			}
		}
		thirdString.append("|");
		for (int i : answer) {
			thirdString.append(i);
		}
		result.add(thirdString.toString());
	}

	private void formatOtherString() {
		int lastTopNumber = dividendMassive[0];
		int lastBottomNumber = answer[0] * divider;
		StringBuilder lastTopPrintedString = new StringBuilder();
		lastTopPrintedString.append(lastTopNumber);
		lastTopPrintedString.insert(0, "_");

		for (int i = 1; i < dividendMassive.length; i++) {
			StringBuilder topString = new StringBuilder();
			topString.append(lastTopNumber - lastBottomNumber);
			String buildTopNumber = topString.toString();
			buildTopNumber += dividendMassive[i];
			topString.insert(0, "_");
			lastTopNumber = Integer.parseInt(buildTopNumber.toString());
			while (topString.length() < lastTopPrintedString.length()) {
				topString.insert(0, " ");
			}
			topString.append(dividendMassive[i]);
			lastTopPrintedString = topString;
			result.add(topString.toString());

			StringBuilder bottomString = new StringBuilder();
			bottomString.append(answer[i] * divider);
			lastBottomNumber = Integer.parseInt(bottomString.toString());
			while (bottomString.length() < topString.length()) {
				bottomString.insert(0, " ");
			}
			result.add(bottomString.toString());
			result.add(getBottomLine(lastTopNumber, lastTopPrintedString));
		}
		result.add(getLastString(lastTopNumber));
	}

	private String getLastString(int lastTopString) {
		StringBuilder lastString = new StringBuilder();
		int bottomNumber = divider * answer[answer.length - 1];
		lastString.append(lastTopString - bottomNumber);
		while (lastString.length() <= howManyDigit(dividend)) {
			lastString.insert(0, " ");
		}
		return lastString.toString();
	}

	private String getBottomLine(int lastNumber, StringBuilder printedString) {
		StringBuilder bottomLine = new StringBuilder();
		while (howManyDigit(lastNumber) > bottomLine.length()) {
			bottomLine.append("-");
		}
		while (printedString.length() > bottomLine.length()) {
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