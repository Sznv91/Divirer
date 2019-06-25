package com.foxminded.divider;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionFormatterTest {

	public DivisionFormatter divisionFormatterInstance;
	public Divider dividerInstance;

	@BeforeEach
	void setUp() throws Exception {
		divisionFormatterInstance = new DivisionFormatter();
		dividerInstance = new Divider();
	}

	@Test
	public void givenDividend78945Divider4_whenDivisionFormatter_thenFormated() {
		int dividend = 78945;
		int divider = 4;
		DivisionResult result = dividerInstance.divide(dividend, divider);
		String expected = divisionFormatterInstance.format(result);
		StringBuilder actual = new StringBuilder();
		actual.append("_78945|4" + System.lineSeparator());
		actual.append(" 4    |-----" + System.lineSeparator());
		actual.append(" -    |19736" + System.lineSeparator());
		actual.append("_38" + System.lineSeparator());
		actual.append(" 36" + System.lineSeparator());
		actual.append(" --" + System.lineSeparator());
		actual.append(" _29" + System.lineSeparator());
		actual.append("  28" + System.lineSeparator());
		actual.append("  --" + System.lineSeparator());
		actual.append("  _14" + System.lineSeparator());
		actual.append("   12" + System.lineSeparator());
		actual.append("   --" + System.lineSeparator());
		actual.append("   _25" + System.lineSeparator());
		actual.append("    24" + System.lineSeparator());
		actual.append("    --" + System.lineSeparator());
		actual.append("     1");
		assertEquals(expected, actual.toString());
	}

	@Test
	public void givenDividend36925814Divider41_whenDivisionFormatter_thenFormated() {
		int dividend = 36925814;
		int divider = 41;
		DivisionResult result = dividerInstance.divide(dividend, divider);
		String expected = divisionFormatterInstance.format(result);
		StringBuilder actual = new StringBuilder();
		actual.append("_36925814|41" + System.lineSeparator());
		actual.append(" 369     |------" + System.lineSeparator());
		actual.append(" ---     |900629" + System.lineSeparator());
		actual.append("   _258" + System.lineSeparator());
		actual.append("    246" + System.lineSeparator());
		actual.append("    ---" + System.lineSeparator());
		actual.append("    _121" + System.lineSeparator());
		actual.append("      82" + System.lineSeparator());
		actual.append("     ---" + System.lineSeparator());
		actual.append("     _394" + System.lineSeparator());
		actual.append("      369" + System.lineSeparator());
		actual.append("      ---" + System.lineSeparator());
		actual.append("       25");
		assertEquals(expected, actual.toString());
	}

}
