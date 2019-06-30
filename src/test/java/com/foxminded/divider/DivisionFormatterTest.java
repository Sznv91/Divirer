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
		StringBuilder expected = new StringBuilder();
		expected.append("_78945|4" + System.lineSeparator());
		expected.append(" 4    |-----" + System.lineSeparator());
		expected.append(" -    |19736" + System.lineSeparator());
		expected.append("_38" + System.lineSeparator());
		expected.append(" 36" + System.lineSeparator());
		expected.append(" --" + System.lineSeparator());
		expected.append(" _29" + System.lineSeparator());
		expected.append("  28" + System.lineSeparator());
		expected.append("  --" + System.lineSeparator());
		expected.append("  _14" + System.lineSeparator());
		expected.append("   12" + System.lineSeparator());
		expected.append("   --" + System.lineSeparator());
		expected.append("   _25" + System.lineSeparator());
		expected.append("    24" + System.lineSeparator());
		expected.append("    --" + System.lineSeparator());
		expected.append("     1");
		
		int dividend = 78945;
		int divider = 4;
		DivisionResult result = dividerInstance.divide(dividend, divider);
		String actual = divisionFormatterInstance.format(result);
		
		assertEquals(actual, expected.toString());
	}

	@Test
	public void givenDividend36925814Divider41_whenDivisionFormatter_thenFormated() {
		StringBuilder expected = new StringBuilder();		
		expected.append("_36925814|41" + System.lineSeparator());
		expected.append(" 369     |------" + System.lineSeparator());
		expected.append(" ---     |900629" + System.lineSeparator());
		expected.append("   _258" + System.lineSeparator());
		expected.append("    246" + System.lineSeparator());
		expected.append("    ---" + System.lineSeparator());
		expected.append("    _121" + System.lineSeparator());
		expected.append("      82" + System.lineSeparator());
		expected.append("     ---" + System.lineSeparator());
		expected.append("     _394" + System.lineSeparator());
		expected.append("      369" + System.lineSeparator());
		expected.append("      ---" + System.lineSeparator());
		expected.append("       25");
		
		int dividend = 36925814;
		int divider = 41;
		DivisionResult result = dividerInstance.divide(dividend, divider);
		String actual = divisionFormatterInstance.format(result);
		
		assertEquals(actual, expected.toString());
	}

}
