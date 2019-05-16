package com.foxminded.divider;

import javax.print.attribute.standard.Finishings;

public class Divider {

	public static void divide(String dividend, String divider) {
		StringBuilder firstNumber = new StringBuilder(dividend.substring(0, divider.length()));
		if (Integer.parseInt(firstNumber.toString()) < Integer.parseInt(divider)) {
			firstNumber.append(dividend.substring(divider.length(), divider.length() + 1));
		}
		int[] numbersOfDividend = new int[dividend.length() - firstNumber.length() + 1];
		numbersOfDividend[0] = Integer.parseInt(firstNumber.toString());
		String remainder = dividend.substring(firstNumber.length());
		int positionNumberInMassive = 1;
		int positionInRemainder = 0;
		while (positionNumberInMassive < numbersOfDividend.length) {
			numbersOfDividend[positionNumberInMassive] = Integer
					.parseInt(remainder.substring(positionInRemainder, positionInRemainder + 1));
			positionNumberInMassive++;
			positionInRemainder++;
		}

		// Сформировали массив чисел, определили первое число для делителя.
		for (int i : numbersOfDividend) {
			System.out.println(i + " contains numbers Of Dividend");
		}
		//для проверки
		System.out.println(new Divider().findingDivider(numbersOfDividend[0], Integer.parseInt(divider)) + " result");
		//
		int one = Integer.parseInt(dividend);
		int two = Integer.parseInt(divider);
		int result = one / two;
		System.out.println(result);
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
