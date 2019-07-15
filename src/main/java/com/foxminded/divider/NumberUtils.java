package com.foxminded.divider;

public class NumberUtils {

	protected static int getDigit(int numeric, int position) {
		int counter = 1;
		int multipler = 1;
		int result = 0;
		for (int i = 1; i < howManyDigit(numeric); i++) {
			multipler = multipler * 10;
		}
		while (counter <= position) {
			if (counter == position) {
				result = numeric / multipler;
				break;
			} else {
				numeric = numeric - ((numeric / multipler) * multipler);
				multipler = multipler / 10;
				counter++;
			}
		}
		return result;
	}

	protected static int howManyDigit(int number) {
		if (number == 0) {
			return 1;
		}
		int result = 0;
		while (number > 0) {
			number = number / 10;
			result++;
		}
		return result;
	}

	protected static int appendDigits(int original, int attached) {
		if (original == 0) {
			return attached;
		}
		return original * 10 + attached;
	}

	protected static int[] decomposeDividend(int dividend) {
		int[] result = new int[howManyDigit(dividend)];
		for (int i = 0; i < result.length; i++) {
			result[i] = getDigit(dividend, i + 1);
		}
		return result;
	}

}
