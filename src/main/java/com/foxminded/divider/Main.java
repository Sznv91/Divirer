package com.foxminded.divider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please entry dividend");
		int dividend = scanner.nextInt();
		System.out.println("Please entry divider");
		int divider = scanner.nextInt();
		scanner.close();
		DivisionFormatter divisionFormatterInstance = new DivisionFormatter();
		ArrayList<String> toPrint = divisionFormatterInstance.format(dividend, divider);
		for(String i : toPrint) {
			System.out.println(i);
		}
	}

}