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
		//Printer printerInstance = new Printer();
		//printerInstance.draw(dividend, divider);	
		Divider dividerInstance = new Divider();
//		int [] toTest = dividerInstance.makeNumMassive(dividend, divider);
//		for (int i : toTest) {
//			System.out.println(i);
//		}
		ArrayList<Integer> forTest = dividerInstance.divide(dividend, divider);
		System.out.println(forTest);
	}

}