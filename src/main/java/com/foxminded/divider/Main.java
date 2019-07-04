package com.foxminded.divider;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please entry dividend");
//		int dividend = scanner.nextInt();
//		System.out.println("Please entry divider");
//		int divider = scanner.nextInt();
//		scanner.close();
//		Divider dividerInstance = new Divider();
//		DivisionResult result = dividerInstance.divide(dividend, divider);
//		DivisionFormatter formatter = new DivisionFormatter();
//		System.out.println(formatter.format(result));
		int dividend = 78945;
		int divider = 4;
		Divider div = new Divider();
		DivisionResult divRes = div.divide(dividend, divider);
		for (int i = 0; i < divRes.getIncompleteQuotient().size();i++) {
			System.out.println(divRes.getIncompleteQuotient().get(i).getRemainder());
		}
	}

}
