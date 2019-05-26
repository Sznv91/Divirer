package com.foxminded.divider;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionFormatterTest {
	
	public DivisionFormatter divisionFormatterInstanse;

	@BeforeEach
	void setUp() throws Exception {
		divisionFormatterInstanse = new DivisionFormatter();
	}

	@Test
	public void givenDividend78945Divider4_whenDivisionFormatter_thenFormated() {
		int dividend = 78945;
		int divider = 4;
		ArrayList <String> expected = new ArrayList<String>();
		expected.add("_78945|4");
		expected.add(" 4    |-----");
		expected.add(" -    |19736");
		expected.add("_38");
		expected.add(" 36");
		expected.add(" --");
		expected.add(" _29");
		expected.add("  28");
		expected.add("  --");
		expected.add("  _14");
		expected.add("   12");
		expected.add("   --");
		expected.add("   _25");
		expected.add("    24");
		expected.add("    --");
		expected.add("     1");
		ArrayList<String> actual = divisionFormatterInstanse.format(dividend, divider);
		assertEquals(expected, actual);
	}
	
	@Test
	public void givenDividend36925814Divider41_whenDivisionFormatter_thenFormated() {
		int dividend = 36925814;
		int divider = 41;
		ArrayList <String> expected = new ArrayList<String>();
		expected.add("_36925814|41");
		expected.add(" 369     |------");
		expected.add(" ---     |900629");
		expected.add("  _02");
		expected.add("    0");
		expected.add("    -");
		expected.add("   _25");
		expected.add("     0");
		expected.add("    --");
		expected.add("   _258");
		expected.add("    246");
		expected.add("    ---");
		expected.add("    _121");
		expected.add("      82");
		expected.add("     ---");
		expected.add("     _394");
		expected.add("      369");
		expected.add("      ---");
		expected.add("       25");
		ArrayList<String> actual = divisionFormatterInstanse.format(dividend, divider);
		assertEquals(expected, actual);
	}

}
