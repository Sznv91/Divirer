package com.foxminded.divider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please entry dividend");
		String dividend = reader.readLine();
		System.out.println("Please entry divider");
		String divider = reader.readLine();
		reader.close();
		Printer printerInstance = new Printer();
		printerInstance.draw(dividend, divider);		
	}

}