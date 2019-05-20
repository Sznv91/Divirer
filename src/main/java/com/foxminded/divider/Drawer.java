package com.foxminded.divider;

import java.util.ArrayList;

public class Drawer {

	private static int dividend, divider;
	private static ArrayList<Integer> answer;
	private static int [] dividendMassive;

	public void draw(String dividend, String divider) {
		Divider dividerInstanse = new Divider();
		this.dividend = Integer.parseInt(dividend);
		this.divider = Integer.parseInt(divider);
		this.answer = dividerInstanse.divide(dividend, divider);
		this.dividendMassive = dividerInstanse.makeNumMassive(dividend, divider);
		
		drawFistString();
		drawSecondString();
		drawThirdString();
		drawOtherString();
		
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

	private void drawOtherString() {
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
