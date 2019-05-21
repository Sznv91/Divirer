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
		int indent = 1; // Общий отступ
		int lastTopString = dividendMassive[0];
		for(int position = 1; position < dividendMassive.length; position++) {
			StringBuilder topString = new StringBuilder();
			topString.append(lastTopString - (divider*answer.get(position-1)));
			indent += howManyNumbers(lastTopString) - howManyNumbers(lastTopString - (divider*answer.get(position-1)));
			// 379-369=9
			// 378 = 3 symbols
			// 9 = 1 symbol
			// 3-1 = 2 symbols indent
			topString.append(dividendMassive[position]);
			lastTopString = Integer.parseInt(topString.toString());
			
			for (int j = 0; j < indent; j++) { //SetUp indent = 1, or use <=
				topString.insert(0, " ");
			}
			
			System.out.println(topString);
			
			//here mast was be Bottom String
			StringBuilder bottomString = new StringBuilder();
			bottomString.append(divider*answer.get(position));
			int indentBottomString = howManyNumbers(Integer.parseInt(bottomString.toString()));
			while (bottomString.length() < topString.length()) {
				bottomString.insert(0, " ");
			}
			
			System.out.println(bottomString.toString());
			
			// here mast was be --- under "bottom String"
			//	//	//	//	//	//	//	//	
		}
	}
	private int howManyNumbers (int num) {
		int counter = 0;
		while (num > 0) {
			num = num/10;
			counter++;
		}
		return counter;
	}

}
