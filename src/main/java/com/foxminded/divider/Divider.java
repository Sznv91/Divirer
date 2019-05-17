package com.foxminded.divider;

import java.util.ArrayList;

public class Divider {

	private static Divider dividerInstance = new Divider();

	public static void divide(String dividend, String divider) {
		int[] numbersOfDividend = dividerInstance.makeNumMassive(dividend, divider);
		int[] toDraw = dividerInstance.makeNumMassive(dividend, divider);
		ArrayList<Integer> result = dividerInstance.getResult(numbersOfDividend, divider);
		dividerInstance.draw(toDraw, Integer.parseInt(dividend), Integer.parseInt(divider), result);
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

	private ArrayList<Integer> getResult(int[] numbersOfDividendTest, String divider) {
		int[] numbersOfDividendTTest = numbersOfDividendTest;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < numbersOfDividendTTest.length; i++) {
			int partOfResult = dividerInstance.
					findingDivider(numbersOfDividendTTest[i], Integer.parseInt(divider));
			result.add(partOfResult);
			int tmp = Integer.parseInt(divider) * partOfResult;
			int remainder = numbersOfDividendTTest[i] - tmp;
			StringBuilder sb = new StringBuilder();
			sb.append(remainder);
			if (i < numbersOfDividendTTest.length - 1) {
				sb.append(numbersOfDividendTTest[i + 1]);
				numbersOfDividendTTest[i + 1] = Integer.parseInt(sb.toString());
			}
		}
		return result;
	}

	private void draw(int[] dividendMassive, int dividend, int divider, ArrayList<Integer> answer) {
		StringBuilder fisrString = new StringBuilder("_");
		fisrString.append(dividend + "|" + divider);

		System.out.println(fisrString.toString());
		StringBuilder secondString = new StringBuilder();
		secondString.append(" " + divider * answer.get(0));
		for (int i = 0; i < String.valueOf(dividend).length() - 1; i++) {
			secondString.append(" ");
		}
		secondString.append("|");
		for (int i = 0; i < answer.size(); i++) {
			secondString.append("-");
		}
		System.out.println(secondString.toString());
		StringBuilder thirdString = new StringBuilder();
		thirdString.append(" -");
		for (int i = 0; i < String.valueOf(dividend).length() - 1; i++) {
			thirdString.append(" ");
		}
		thirdString.append("|");
		for (int i : answer) {
			thirdString.append(i);
		}
		System.out.println(thirdString.toString());

		int lastResult = 0;
		int positionInDivident = 0;
		int positionInAnswer = 0;
		
		while (true) {
			if (positionInDivident != dividendMassive.length) {
				if (positionInDivident < 1) {
					lastResult = dividendMassive[positionInDivident] - (divider * answer.get(positionInAnswer));
					positionInDivident++;
					positionInAnswer++;
				} else {
					StringBuilder collector = new StringBuilder();
					collector.append(lastResult);
					collector.append(dividendMassive[positionInDivident]);
					int curentDiv = Integer.parseInt(collector.toString());
					lastResult = curentDiv - (divider * answer.get(positionInAnswer));
					for(int i = 0; i < positionInDivident; i++) {
						collector.insert(0, " ");
					}
					System.out.println(collector.toString());
					StringBuilder secondNumber = new StringBuilder();
					for(int i = 0; i < positionInDivident; i ++) {
						secondNumber.insert(0, " ");
					}
					secondNumber.append(divider * answer.get(positionInAnswer));
					System.out.println(secondNumber);
					positionInDivident++;
					positionInAnswer++;
				}
			} else {
				break;
			}
		}
	}
}
