package com.foxminded.divider;

import java.util.ArrayList;

public class Divider {

	public ArrayList<Integer> divide(int dividend, int divider) {
		int[] numbersOfDividend = makeNumMassive(dividend, divider);
		//ArrayList<Integer> result = calcResult(numbersOfDividend, divider);
		//return result;
	}

	private Integer findingDivider(int dividend, int divider) {
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
		return numbersOfDividend;
	}

	private ArrayList<Integer> calcResult(int[] numbersOfDividend, int divider) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < numbersOfDividend.length; i++) {
			int partOfResult = findingDivider(numbersOfDividend[i], Integer.parseInt(divider));
			result.add(partOfResult);
			int tmp = Integer.parseInt(divider) * partOfResult;
			int remainder = numbersOfDividend[i] - tmp;
			StringBuilder sb = new StringBuilder();
			sb.append(remainder);
			if (i < numbersOfDividend.length - 1) {
				sb.append(numbersOfDividend[i + 1]);
				numbersOfDividend[i + 1] = Integer.parseInt(sb.toString());
			}
		}
		return result;
	}
	
	private Integer getDigit (int numeric, int position) {
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
}