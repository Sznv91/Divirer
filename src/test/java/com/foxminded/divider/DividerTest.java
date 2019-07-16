package com.foxminded.divider;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DividerTest {

	public Divider divider;

	@Before
	public void setUp() throws Exception {
		divider = new Divider();
	}

	@Test
	public void givenDividend78945Divider4_whenDivide_then19736() {
		DivisionResult expected = new DivisionResult(78945, 4);
		expected.setResult(19736);
		expected.setDivisionStep(7, 4);
		expected.setDivisionStep(38, 36);
		expected.setDivisionStep(29, 28);
		expected.setDivisionStep(14, 12);
		expected.setDivisionStep(25, 24);
		expected.setDivisionStep(1, 0);
		
		DivisionResult actual = divider.divide(78945, 4);
		
		assertEquals(expected, actual);
	}

	@Test
	public void givenDividend362514Divider41_whenDivide_then8841() {
		DivisionResult expected = new DivisionResult(362514, 41);
		expected.setResult(8841);
		expected.setDivisionStep(362, 328);
		expected.setDivisionStep(345, 328);
		expected.setDivisionStep(171, 164);
		expected.setDivisionStep(74, 41);
		expected.setDivisionStep(33, 0);
		
		DivisionResult actual = divider.divide(362514, 41);
		
		assertEquals(expected, actual);
	}

}