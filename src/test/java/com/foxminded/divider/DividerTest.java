package com.foxminded.divider;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
		List<Integer> incompleteQuotient = new ArrayList<>();
		incompleteQuotient.add(7);
		incompleteQuotient.add(38);
		incompleteQuotient.add(29);
		incompleteQuotient.add(14);
		incompleteQuotient.add(25);
		incompleteQuotient.add(1);
		expected.setIncompleteQuotient(incompleteQuotient);
		List<Integer> remainder = new ArrayList<>();
		remainder.add(4);
		remainder.add(36);
		remainder.add(28);
		remainder.add(12);
		remainder.add(24);
		expected.setRemainder(remainder);
		DivisionResult actual = dividerInstanse.divide(78945, 4);
		assertEquals(expected.getIncompleteQuotient(), actual.getIncompleteQuotient());
		assertEquals(expected.getRemainder(), actual.getRemainder());
		assertEquals(expected.getDivident(), actual.getDivident());
		assertEquals(expected.getDivider(), actual.getDivider());
		assertEquals(expected.getResult(), actual.getResult());
	}

	@Test
	public void givenDividend362514Divider41_whenDivide_then8841() {
		DivisionResult expected = new DivisionResult(362514, 41);
		expected.setResult(8841);
		List<Integer> incompleteQuotient = new ArrayList<>();
		incompleteQuotient.add(362);
		incompleteQuotient.add(345);
		incompleteQuotient.add(171);
		incompleteQuotient.add(74);
		incompleteQuotient.add(33);
		expected.setIncompleteQuotient(incompleteQuotient);
		List<Integer> remainder = new ArrayList<>();
		remainder.add(328);
		remainder.add(328);
		remainder.add(164);
		remainder.add(41);
		expected.setRemainder(remainder);
		DivisionResult actual = dividerInstanse.divide(362514, 41);
		assertEquals(expected.getResult(), actual.getResult());
		assertEquals(expected.getDivident(), actual.getDivident());
		assertEquals(expected.getIncompleteQuotient(), actual.getIncompleteQuotient());
		assertEquals(expected.getRemainder(), actual.getRemainder());
		assertEquals(expected.getDivider(), actual.getDivider());
	}

}