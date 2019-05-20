package com.foxminded.divider;

import java.util.ArrayList;

public class Drawer {

	private static String dividend, divider;
	private static ArrayList<Integer> answer;

	public void draw(String dividend, String divider) {
		this.dividend = dividend;
		this.divider = divider;

		Divider dividerInstanse = new Divider();
		this.answer = dividerInstanse.divide(dividend, divider);

	}

	private int[] makeNumMassive(String dividend, String divider) {
		StringBuilder incompletePrivate = new StringBuilder(dividend.substring(0, divider.length()));
		if (Integer.parseInt(incompletePrivate.toString()) < Integer.parseInt(divider)) {
			incompletePrivate.append(dividend.substring(divider.length(), divider.length() + 1));
		}
		int[] numbersOfDividend = new int[dividend.length() - incompletePrivate.length() + 1];
		numbersOfDividend[0] = Integer.parseInt(incompletePrivate.toString());
		String otherNumberInMassive = dividend.substring(incompletePrivate.length());
		int positionNumberInMassive = 1;
		int positionInRemainder = 0;
		while (positionNumberInMassive < numbersOfDividend.length) {
			numbersOfDividend[positionNumberInMassive] = Integer
					.parseInt(otherNumberInMassive.substring(positionInRemainder, positionInRemainder + 1));
			positionNumberInMassive++;
			positionInRemainder++;
		}
		return numbersOfDividend;
	}

	private void drawFistString() {
		StringBuilder fisrString = new StringBuilder("_");
		fisrString.append(dividend + "|" + divider);
		System.out.println(fisrString.toString());
	}

	private void drawSecondString() {
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

	private void drawThirdString() {
		StringBuilder thirdString = new StringBuilder();
		thirdString.append(" ");
		for (int i = 0; i < String.valueOf(dividend).length(); i++) {
			if (i < String.valueOf(answer.get(0) * divider).length()) {
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

	private void drawOtherString(int[] dividendMassive, int dividend, int divider, ArrayList<Integer> answer) {
		int counterOtstup = 1;
		int massiveCounter = 0;
		int lastResult = dividendMassive[0];
		int answerCounter = 0;
		while (massiveCounter < dividendMassive.length - 1) {
			int lasLen = String.valueOf(lastResult).length();
			int umnoj = divider * answer.get(answerCounter);
			StringBuilder sb = new StringBuilder();
			sb.append(lastResult - umnoj);
			int sbLen = sb.length();
			sb.append(dividendMassive[massiveCounter + 1]);
			lastResult = Integer.parseInt(sb.toString());
			if (lasLen - sbLen < 2 && lasLen <= 1) {
				for (int i = 0; i < counterOtstup; i++) {
					sb.insert(0, " ");
				}
			} else {
				for (int i = 0; i < lasLen - sbLen + counterOtstup; i++) {
					sb.insert(0, " ");
				}
			}

			System.out.println(sb.toString());

			StringBuilder twoNumber = new StringBuilder();
			twoNumber.append("" + (answer.get(answerCounter + 1) * divider));

			if (lasLen - sbLen < 2 && lasLen <= 1) {
				for (int i = 0; i < counterOtstup; i++) {
					twoNumber.insert(0, " ");
				}
			} else {
				for (int i = 0; i < lasLen - sbLen + counterOtstup; i++) {
					twoNumber.insert(0, " ");
				}
			}
			System.out.println(twoNumber);
			massiveCounter++;
			answerCounter++;
			counterOtstup++;
		}
	}

}
