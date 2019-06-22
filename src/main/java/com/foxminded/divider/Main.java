package com.foxminded.divider;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please entry dividend");
		int dividend = scanner.nextInt();
		System.out.println("Please entry divider");
		int divider = scanner.nextInt();
		scanner.close();
		Divider div = new Divider();
		DivisionResult result = div.getResult(dividend, divider);
		DivisionFormatter formatter = new DivisionFormatter();
		System.out.println(formatter.format(result));
		
		
//		Divider div = new Divider();
//		DivisionResult divisionResult;
//		divisionResult = div.getResult(78945, 4);
//		DivisionFormatter format = new DivisionFormatter();
//		System.out.println(format.format(divisionResult));
	}

}
