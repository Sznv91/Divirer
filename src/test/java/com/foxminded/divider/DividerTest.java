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
		int[] expected = {1,9,7,3,6};
		int[] actual = dividerInstanse.divide(78945, 4);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void givenDividend362514Divider41_whenDivide_then8841() {
		int[] expected = {8,8,4,1};
		int[] actual = dividerInstanse.divide(362514, 41);
		assertArrayEquals(expected, actual);
	}

}