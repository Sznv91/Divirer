package com.foxminded.divider;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
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
		int[] expected = {1,9,7,3,6};
		int[] actual = dividerInstanse.divide(78945, 4);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void givenDividend78945Divider4_whenMakeNumMassive_then7_8_9_4_5() {
		int[] expected = { 7, 8, 9, 4, 5 };
		int[] actual = dividerInstanse.makeNumMassive(78945, 4);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void givenDividend362514Divider41_whenDivide_then8841() {
		int[] expected = {8,8,4,1};
		int[] actual = dividerInstanse.divide(362514, 41);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void givenDividend362514Divider41_whenMakeNumMassive_then362_5_1_4() {
		int[] expected = { 362, 5, 1, 4 };
		int[] actual = dividerInstanse.makeNumMassive(362514, 41);
		assertArrayEquals(expected, actual);
	}

//	@Test
//	public void givenDividendZeroDividerZero_whenDivide_thenArithmeticException() throws IOException {
//		Throwable thrown = assertThrows(ArithmeticException.class, () -> {
//			ArrayList<Integer> actual = dividerInstanse.divide(0, 0);
//		});
//		assertNotNull(thrown.getMessage());
//	}
//
//	@Test
//	public void givenDividend7894DividerNull_whenDivide_thenNull() {
//		ArrayList<Integer> expected = null;
//		ArrayList<Integer> actual = dividerInstanse.divide(7894, 0);
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void givenDividendNullDivider4_whenDivide_thenNull() {
//		ArrayList<Integer> expected = null;
//		ArrayList<Integer> actual = dividerInstanse.divide(0, 4);
//		assertEquals(expected, actual);
//	}

}