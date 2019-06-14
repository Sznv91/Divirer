package com.foxminded.divider;

import static org.junit.jupiter.api.Assertions.*;

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
		Divider div = new Divider();
		DivisionResult result = div.getResult(dividend, divider);
		String expected = divisionFormatterInstanse.format(result);
		StringBuilder sb = new StringBuilder();
		sb.append("_78945|4");
		sb.append(System.lineSeparator() + " 4    |-----");
		sb.append(System.lineSeparator() + " -    |19736");
		sb.append(System.lineSeparator() + "_38");
		sb.append(System.lineSeparator() + " 36");
		sb.append(System.lineSeparator() + " --");
		sb.append(System.lineSeparator() + " _29");
		sb.append(System.lineSeparator() + "  28");
		sb.append(System.lineSeparator() + "  --");
		sb.append(System.lineSeparator() + "  _14");
		sb.append(System.lineSeparator() + "   12");
		sb.append(System.lineSeparator() + "   --");
		sb.append(System.lineSeparator() + "   _25");
		sb.append(System.lineSeparator() + "    24");
		sb.append(System.lineSeparator() + "    --");
		sb.append(System.lineSeparator() + "     1");
		String actual = sb.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void givenDividend36925814Divider41_whenDivisionFormatter_thenFormated() {
		int dividend = 36925814;
		int divider = 41;
		Divider div = new Divider();
		DivisionResult result = div.getResult(dividend, divider);
		String expected = divisionFormatterInstanse.format(result);
		StringBuilder sb = new StringBuilder();
		sb.append("_36925814|41");
		sb.append(System.lineSeparator() + " 369     |------");
		sb.append(System.lineSeparator() + " ---     |900629");
		sb.append(System.lineSeparator() + "   _2");
		sb.append(System.lineSeparator() + "    0");
		sb.append(System.lineSeparator() + "    -");
		sb.append(System.lineSeparator() + "   _25");
		sb.append(System.lineSeparator() + "     0");
		sb.append(System.lineSeparator() + "    --");
		sb.append(System.lineSeparator() + "   _258");
		sb.append(System.lineSeparator() + "    246");
		sb.append(System.lineSeparator() + "    ---");
		sb.append(System.lineSeparator() + "    _121");
		sb.append(System.lineSeparator() + "      82");
		sb.append(System.lineSeparator() + "     ---");
		sb.append(System.lineSeparator() + "     _394");
		sb.append(System.lineSeparator() + "      369");
		sb.append(System.lineSeparator() + "      ---");
		sb.append(System.lineSeparator() + "       25");
		String actual = sb.toString();
		assertEquals(expected, actual);
	}

}
