package com.foxminded.divider;

import java.util.List;

public class DivisionResult {
	
	private int dividend;
	private int divider;
	private int result;
	private IncompleteQuotientAndRemaider innerCalcResult = new IncompleteQuotientAndRemaider();

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
		return innerCalcResult.getIncompleteQuotient();
	}

	public void setIncompleteQuotient(List<Integer> incompleteQuotient) {
		this.innerCalcResult.setIncompleteQuotient(incompleteQuotient);
	}

	public List<Integer> getRemainder() {
		return innerCalcResult.getRemainder();
	}

	public void setRemainder(List<Integer> remainder) {
		this.innerCalcResult.setRemainder(remainder);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
