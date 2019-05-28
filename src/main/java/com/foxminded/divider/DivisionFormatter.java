package com.foxminded.divider;

import java.util.ArrayList;

public class DivisionFormatter {

	public ArrayList<String> format(int dividend, int divider) {
		Divider dividerInstanse = new Divider();
		int[][] divideMassiv = dividerInstanse.divide(dividend, divider);
		ArrayList<String> result = new ArrayList<String>();

		formatFirstString(dividend, divider, result);
		formatSecondString(dividend, divider, result, divideMassiv);
		formatThirdString(dividend, divider, result, divideMassiv);
		formatOtherString(dividend, divider, result, divideMassiv);
		return result;
	}

	private void formatFirstString(int dividend, int divider, ArrayList<String> result) {
		StringBuilder firstString = new StringBuilder("_");
		firstString.append(dividend + "|" + divider);
		result.add(firstString.toString());
	}

	private void formatSecondString(int dividend, int divider, ArrayList<String> result, int[][] dividendMassive) {
		StringBuilder secondString = new StringBuilder();
		secondString.append(" " + dividendMassive[3][0]);
		for (int i = 0; i < dividendMassive[0].length - 1; i++) {
			secondString.append(" ");
		}
		secondString.append("|");
		for (int i = 0; i < dividendMassive[1].length; i++) {
			secondString.append("-");
		}
		result.add(secondString.toString());
	}

	private void formatThirdString(int dividend, int divider, ArrayList<String> result, int[][] dividendMassive) {
		StringBuilder thirdString = new StringBuilder();
		thirdString.append(" ");
		for (int i = 0; i < howManyDigit(dividend); i++) {
			if (i < howManyDigit(dividendMassive[3][0])) {
				thirdString.append("-");
			} else {
				thirdString.append(" ");
			}
		}
		thirdString.append("|");
		for (int i : dividendMassive[1]) {
			thirdString.append(i);
		}
		result.add(thirdString.toString());
	}

	private void formatOtherString(int dividend, int divider, ArrayList<String> result, int[][] dividendMassive) {
		int lastLenghString = howManyDigit(dividendMassive[0][0]);

		for (int i = 1; i < dividendMassive[0].length; i++) {
			StringBuilder formatedString = new StringBuilder();
			formatedString.append("_" + dividendMassive[2][i]);
			lastLenghString++;
			while (formatedString.length() <= lastLenghString) {
				formatedString.insert(0, " ");
			}
			result.add(formatedString.toString());

			formatedString = new StringBuilder();
			formatedString.append(dividendMassive[3][i]);
			while (formatedString.length() <= lastLenghString) {
				formatedString.insert(0, " ");
			}
			result.add(formatedString.toString());
			result.add(getBottomLine(dividendMassive[2][i], formatedString));
		}
		result.add(getLastString(dividendMassive, lastLenghString));
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