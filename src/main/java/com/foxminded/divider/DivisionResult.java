package com.foxminded.divider;

import java.util.ArrayList;

public class DivisionResult {
	private int dividend;
	private int divider;
	private int result;
	private ArrayList<Integer> incompleteQuotient;
	private ArrayList<Integer> remainder;

	public DivisionResult(int divident, int divider) {
		super();
		this.dividend = divident;
		this.divider = divider;
	}

	public int getDivident() {
		return dividend;
	}

	public int getDivider() {
		return divider;
	}

	public ArrayList<Integer> getIncompleteQuotient() {
		return incompleteQuotient;
	}

	public void setIncompleteQuotient(ArrayList<Integer> incompleteQuotient) {
		this.incompleteQuotient = incompleteQuotient;
	}

	public ArrayList<Integer> getRemainder() {
		return remainder;
	}

	public void setRemainder(ArrayList<Integer> remainder) {
		this.remainder = remainder;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
