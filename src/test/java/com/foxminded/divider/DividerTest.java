package com.foxminded.divider;

import static org.junit.jupiter.api.Assertions.*;

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
		DivisionResult expected = new DivisionResult(new int[] { 7, 8, 9, 4, 5 }, 4);
		expected.setResult(new int[] { 1, 9, 7, 3, 6 });
		expected.setUpperResults(new int[] { 7, 38, 29, 14, 25, 1 });
		expected.setDownerResults(new int[] { 4, 36, 28, 12, 24 });
		DivisionResult actual = dividerInstanse.getResult(78945, 4);
		assertArrayEquals(expected.getResult(), actual.getResult());
		assertArrayEquals(expected.getDivident(), actual.getDivident());
		assertArrayEquals(expected.getDownerResults(), actual.getDownerResults());
		assertArrayEquals(expected.getUpperResults(), actual.getUpperResults());
		assertEquals(expected.getDivider(), actual.getDivider());
	}

	@Test
	public void givenDividend362514Divider41_whenDivide_then8841() {
		DivisionResult expected = new DivisionResult(new int[] { 362, 5, 1, 4 }, 41);
		expected.setResult(new int[] { 8, 8, 4, 1 });
		expected.setUpperResults(new int[] { 362, 345, 171, 74, 33 });
		expected.setDownerResults(new int[] { 328, 328, 164, 41 });
		DivisionResult actual = dividerInstanse.getResult(362514, 41);
		assertArrayEquals(expected.getResult(), actual.getResult());
		assertArrayEquals(expected.getDivident(), actual.getDivident());
		assertArrayEquals(expected.getDownerResults(), actual.getDownerResults());
		assertArrayEquals(expected.getUpperResults(), actual.getUpperResults());
		assertEquals(expected.getDivider(), actual.getDivider());
	}

}