package com.foxminded.divider;

import java.util.List;

public class DivisionResult {
	private int dividend;
	private int divider;
	private int result;
	private List<Integer> incompleteQuotient;
	private List<Integer> remainder;

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

	public List<Integer> getIncompleteQuotient() {
		return incompleteQuotient;
	}

	public void setIncompleteQuotient(List<Integer> incompleteQuotient) {
		this.incompleteQuotient = incompleteQuotient;
	}

	public List<Integer> getRemainder() {
		return remainder;
	}

	public void setRemainder(List<Integer> remainder) {
		this.remainder = remainder;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
