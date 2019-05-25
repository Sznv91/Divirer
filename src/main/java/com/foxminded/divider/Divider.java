package com.foxminded.divider;

import java.util.ArrayList;

public class Divider {

	public ArrayList<Integer> divide(int dividend, int divider) {
		int[] numbersOfDividend = makeNumMassive(dividend, divider);
		ArrayList<Integer> result = calcResult(numbersOfDividend, divider);
		return result;
	}

	private Integer findingAnswerCell(int dividend, int divider) {
		int result = 9;
		while (true) {
			if (dividend - (divider * result) >= 0) {
				return result;
			} else {
				result--;
			}
		}
	}

	protected int[] makeNumMassive(int dividend, int divider) {
		StringBuilder firstCell = new StringBuilder();
		StringBuilder otherDigits = new StringBuilder();
		otherDigits.append(dividend);
		firstCell.append(otherDigits.substring(0,1));
		otherDigits.delete(0, 1);
		while (Integer.parseInt(firstCell.toString()) / divider == 0) {
			firstCell.append(otherDigits.substring(0,1));
			otherDigits.delete(0, 1);
		}
		int[] numbersOfDividend = new int[otherDigits.length()+1];
		numbersOfDividend[0] = Integer.parseInt(firstCell.toString());
		for (int i = 1; i < numbersOfDividend.length; i ++) {
			numbersOfDividend[i] = Integer.parseInt(otherDigits.substring(0,1));
			otherDigits.delete(0, 1);
		}
		System.out.println(joiningDigits(numbersOfDividend[0], numbersOfDividend[1]) + " Ожидается 3625");
		return numbersOfDividend;
	}

	private ArrayList<Integer> calcResult(int[] numbersOfDividend, int divider) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int lastValue = 0;
		for(int i = 0; i < numbersOfDividend.length; i++) {
			lastValue = joiningDigits(lastValue, numbersOfDividend[i]);
			int answerCell = findingAnswerCell(lastValue, divider);
			result.add(answerCell);
			lastValue = lastValue - (answerCell * divider);
		}
		
		return result;
	}
	
	private Integer getDigit (int numeric, int position) {
		int cou
		StringBuilder sb = new StringBuilder();
		sb.append(numeric);
		String result = sb.substring(position,position+1).toString();
		return Integer.parseInt(result);
	}
	
	private Integer howManyDigit(int numeric) {
		if(numeric == 0) {
			return 1;
		}
		int result = 0;
		while(numeric > 0) {
			numeric = numeric / 10;
			result ++;
		}
		return result;
	}
	private Integer joiningDigits (int firstDigit, int secondDigit) {
		if(firstDigit == 0) {
			return secondDigit;
		}
		int multipler = 1;
		int result = 0;
		int counter = howManyDigit(secondDigit);
		while(counter != 0) {
			result += getDigit(secondDigit, counter - 1) * multipler;
			counter--;
			multipler = multipler*10;
		}
		counter = howManyDigit(firstDigit);
		while(counter != 0) {
			result += getDigit(firstDigit, counter -1) * multipler;
			counter--;
			multipler = multipler*10;
		}
		return result;
	}
}