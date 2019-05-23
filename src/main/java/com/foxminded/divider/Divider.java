package com.foxminded.divider;

import java.util.ArrayList;

public class Divider {

	public ArrayList<Integer> divide(String dividend, String divider) {
		if(dividend == null || divider == null) {
			return null;
		}
		int[] numbersOfDividend = makeNumMassive(dividend, divider);
		ArrayList<Integer> result = calcResult(numbersOfDividend, divider);
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
		String otherNumber = dividend.substring(incompletePrivate.length());
		int positionNumberInMassive = 1;
		int positionInOtherNumber = 0;
		while (positionNumberInMassive < numbersOfDividend.length) {
			numbersOfDividend[positionNumberInMassive] = Integer
					.parseInt(otherNumber.substring(positionInOtherNumber, positionInOtherNumber + 1));
			positionNumberInMassive++;
			positionInOtherNumber++;
		}
		return numbersOfDividend;
	}

	private ArrayList<Integer> calcResult(int[] numbersOfDividend, String divider) {
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
}