package com.foxminded.divider;

import java.util.ArrayList;

public class Divider {

	private static int[] numbersOfDividend;
	private static Divider dividerInstance = new Divider();

	public ArrayList<Integer> divide(String dividend, String divider) {
		this.numbersOfDividend = dividerInstance.makeNumMassive(dividend, divider);
		ArrayList<Integer> result = dividerInstance.calcResult(numbersOfDividend, divider);
		return result;
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

	protected int[] makeNumMassive(String dividend, String divider) {
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

	private ArrayList<Integer> calcResult(int[] numbersOfDividendTest, String divider) {
		int[] numbersOfDividendTTest = numbersOfDividendTest;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < numbersOfDividendTTest.length; i++) {
			int partOfResult = dividerInstance.findingDivider(numbersOfDividendTTest[i], Integer.parseInt(divider));
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
}
