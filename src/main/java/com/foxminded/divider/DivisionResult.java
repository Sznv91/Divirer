package com.foxminded.divider;

import java.util.List;

public class DivisionResult {
	
	private int dividend;
	private int divider;
	private int result;
	//private IncompleteQuotientAndRemaider innerCalcResult = new IncompleteQuotientAndRemaider();
	private List<Integer> incompleteQuotient;
	private List<Integer> remainder;

	public DivisionResult(int dividend, int divider) {
		super();
		this.dividend = dividend;
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
		//return innerCalcResult.getIncompleteQuotient();
	}

	public void setIncompleteQuotient(List<Integer> incompleteQuotient) {
		this.incompleteQuotient = incompleteQuotient;
		//this.innerCalcResult.setIncompleteQuotient(incompleteQuotient);
	}

	public List<Integer> getRemainder() {
		return remainder;
		//return innerCalcResult.getRemainder();
	}

	public void setRemainder(List<Integer> remainder) {
		this.remainder = remainder;
		//this.innerCalcResult.setRemainder(remainder);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivisionResult other = (DivisionResult) obj;
		if (dividend != other.dividend)
			return false;
		if (divider != other.divider)
			return false;
		if (incompleteQuotient == null) {
			if (other.incompleteQuotient != null)
				return false;
		} else if (!incompleteQuotient.equals(other.incompleteQuotient))
			return false;
		if (remainder == null) {
			if (other.remainder != null)
				return false;
		} else if (!remainder.equals(other.remainder))
			return false;
		if (result != other.result)
			return false;
		return true;
	}

}
