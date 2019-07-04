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
		DivisionResult expected = new DivisionResult(78945, 4);
		expected.setResult(19736);
		expected.setIncompleteQuotientAndRemainder(7, 4);
		expected.setIncompleteQuotientAndRemainder(38, 36);
		expected.setIncompleteQuotientAndRemainder(29, 28);
		expected.setIncompleteQuotientAndRemainder(14, 12);
		expected.setIncompleteQuotientAndRemainder(25, 24);
		expected.setIncompleteQuotientAndRemainder(1, 0);
		
		DivisionResult actual = dividerInstanse.divide(78945, 4);
		
		assertEquals(expected, actual);
	}

	@Test
	public void givenDividend362514Divider41_whenDivide_then8841() {
		DivisionResult expected = new DivisionResult(362514, 41);
		expected.setResult(8841);
		expected.setIncompleteQuotientAndRemainder(362, 328);
		expected.setIncompleteQuotientAndRemainder(345, 328);
		expected.setIncompleteQuotientAndRemainder(171, 164);
		expected.setIncompleteQuotientAndRemainder(74, 41);
		expected.setIncompleteQuotientAndRemainder(33, 0);
		
		DivisionResult actual = dividerInstanse.divide(362514, 41);
		
		assertEquals(expected, actual);
	}

}