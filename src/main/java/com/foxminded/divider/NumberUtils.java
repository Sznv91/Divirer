package com.foxminded.divider;

public class NumberUtils {
	
	protected static Integer getDigit(int numeric, int position) {
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

	protected static Integer howManyDigit(int number) {
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

	protected static Integer appendDigits(int appended, int add) {
		if (appended == 0) {
			return add;
		}
		int multipler = 1;
		int result = 0;
		int counter = howManyDigit(add);
		while (counter != 0) {
			result += getDigit(add, counter) * multipler;
			counter--;
			multipler = multipler * 10;
		}
		counter = howManyDigit(appended);
		while (counter != 0) {
			result += getDigit(appended, counter) * multipler;
			counter--;
			multipler = multipler * 10;
		}
		return result;
	}

}
