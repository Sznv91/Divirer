package com.foxminded.divider;

import java.util.ArrayList;

public class Printer {

	private static int dividend, divider;
	private static ArrayList<Integer> answer;
	private static int[] dividendMassive;

	public void draw(String dividend, String divider) {
		Divider dividerInstanse = new Divider();
		this.dividend = Integer.parseInt(dividend);
		this.divider = Integer.parseInt(divider);
		this.answer = dividerInstanse.divide(dividend, divider);
		this.dividendMassive = dividerInstanse.makeNumMassive(dividend, divider);

		printFirstString();
		printSecondString();
		printThirdString();
		printOtherString();

	}

	private void printFirstString() {
		StringBuilder firstString = new StringBuilder("_");
		firstString.append(dividend + "|" + divider);
		System.out.println(firstString.toString());
	}

	private void printSecondString() {
		StringBuilder secondString = new StringBuilder();
		secondString.append(" " + divider * answer.get(0));
		for (int i = 0; i < dividendMassive.length - 1; i++) {
			secondString.append(" ");
		}
		secondString.append("|");
		for (int i = 0; i < answer.size(); i++) {
			secondString.append("-");
		}
		System.out.println(secondString.toString());
	}

	private void printThirdString() {
		StringBuilder thirdString = new StringBuilder();
		thirdString.append(" ");
		for (int i = 0; i < howManyDigit(dividend); i++) {
			if (i < howManyDigit(answer.get(0) * divider)) {
				thirdString.append("-");
			} else {
				thirdString.append(" ");
			}
		}
		thirdString.append("|");
		for (int i : answer) {
			thirdString.append(i);
		}
		System.out.println(thirdString.toString());
	}

	private void printOtherString() {
		int indent = 1; // setUp 1, because first string have "-"
		int lastTopString = dividendMassive[0];
		for (int position = 1; position < dividendMassive.length; position++) {
			StringBuilder topString = new StringBuilder();
			topString.append(lastTopString - (divider * answer.get(position - 1)));
			indent += howManyDigit(lastTopString) - howManyDigit(lastTopString - (divider * answer.get(position - 1)));
			// 379-369=9
			// 378 = 3 symbols
			// 9 = 1 symbol
			// 3-1 = 2 symbols indent
			topString.append(dividendMassive[position]);
			lastTopString = Integer.parseInt(topString.toString());
			topString.insert(0, "_");

			while (indent >= topString.length() - 1) { // "-1" because print "-" in 75 String
				topString.insert(0, " ");
			}
			System.out.println(topString);

			StringBuilder bottomString = new StringBuilder();
			bottomString.append(divider * answer.get(position));
			if (Integer.parseInt(bottomString.toString()) == 0) {
				indent++;
			}
			while (bottomString.length() < topString.length()) {
				bottomString.insert(0, " ");
			}
			System.out.println(bottomString.toString());
			System.out.println(getBottomLine(lastTopString, topString));

		}
		System.out.println(getLastString(lastTopString));
	}

	private String getLastString(int lastTopString) {
		StringBuilder lastString = new StringBuilder();
		int bottomNumber = divider * answer.get(answer.size() - 1);
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
