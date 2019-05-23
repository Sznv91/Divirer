package com.foxminded.divider;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Integer.parseInt;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DividerTest {

	public Divider dividerInstanse;

	@BeforeEach
	public void setUp() throws Exception {
		dividerInstanse = new Divider();
	}

	@Test
	public void givenDividend78945Divider4_whenDivide_then19736() {
		ArrayList<Integer> expected = new ArrayList<Integer>();
		String result = "19736";
		for (int i = 0; i < result.length(); i++) {
			expected.add(parseInt(result.substring(i, i + 1)));
		}
		ArrayList<Integer> actual = dividerInstanse.divide("78945", "4");
		assertEquals(expected, actual);
	}

	@Test
	public void givenDividend78945Divider4_whenMakeNumMassive_then7_8_9_4_5() {
		int[] expected = {7,8,9,4,5};
		int[] actual = dividerInstanse.makeNumMassive("78945", "4");
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void givenDividend362514Divider41_whenDivide_then8841() {
		ArrayList<Integer> expected = new ArrayList<Integer>();
		String result = "8841";
		for (int i = 0; i < result.length(); i++) {
			expected.add(parseInt(result.substring(i, i + 1)));
		}
		ArrayList<Integer> actual = dividerInstanse.divide("362514", "41");
		assertEquals(expected, actual);
	}

	@Test
	public void givenDividend362514Divider41_whenMakeNumMassive_then362_5_1_4() {
		int[] expected = {362,5,1,4};
		int[] actual = dividerInstanse.makeNumMassive("362514", "41");
		assertArrayEquals(expected, actual);
	}
}