package com.foxminded.divider;

import java.util.ArrayList;

import javax.print.attribute.standard.Finishings;

public class Divider {

	public static void divide(String dividend, String divider) {
		StringBuilder firstNumber = new StringBuilder(dividend.substring(0, divider.length()));
		if (Integer.parseInt(firstNumber.toString()) < Integer.parseInt(divider)) {
			firstNumber.append(dividend.substring(divider.length(), divider.length() + 1));
		}
		int[] numbersOfDividend = new int[dividend.length() - firstNumber.length() + 1];
		numbersOfDividend[0] = Integer.parseInt(firstNumber.toString());
		String otherNumberInMassive = dividend.substring(firstNumber.length());
		int positionNumberInMassive = 1;
		int positionInRemainder = 0;
		while (positionNumberInMassive < numbersOfDividend.length) {
			numbersOfDividend[positionNumberInMassive] = Integer
					.parseInt(otherNumberInMassive.substring(positionInRemainder, positionInRemainder + 1));
			positionNumberInMassive++;
			positionInRemainder++;
		}

		// Сформировали массив чисел, определили первое число для делителя.
		Divider dividerInstance = new Divider();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < numbersOfDividend.length; i++) {
			int partOfResult = dividerInstance.
					findingDivider(numbersOfDividend[i], Integer.parseInt(divider));
			result.add(partOfResult); 
			int tmp = Integer.parseInt(divider) * partOfResult;
			int remainder = numbersOfDividend[i] - tmp;
			StringBuilder sb = new StringBuilder();
			sb.append(remainder);
			System.out.println(sb.toString());
			if (i < numbersOfDividend.length - 1) {
				sb.append(numbersOfDividend[i + 1]);
				numbersOfDividend[i + 1] = Integer.parseInt(sb.toString());
				System.out.println(numbersOfDividend[i + 1] + "cells");
			}
		}
		for (int i : result) {
			System.out.println(i + "result");
		}
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
}
