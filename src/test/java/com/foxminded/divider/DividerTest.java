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
		int[][] expected = {{7,8,9,4,5},{1,9,7,3,6},{7,38,29,14,25},{4,36,28,12,24}};
		int[][] actual = dividerInstanse.divide(78945, 4);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void givenDividend362514Divider41_whenDivide_then8841() {
		int[][] expected = {{362,5,1,4},{8,8,4,1},{362,345,171,74},{328,328,164,41}};
		int[][] actual = dividerInstanse.divide(362514, 41);
		assertArrayEquals(expected, actual);
	}

}