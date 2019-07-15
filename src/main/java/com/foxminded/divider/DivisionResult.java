package com.foxminded.divider;

import java.util.ArrayList;
import java.util.List;

public class DivisionResult {

	private int dividend;
	private int divider;
	private int result;
	private List<DivisionStep> incompleteQuotientAndRemaider = new ArrayList<>();

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

	public List<DivisionStep> getStepsDigit() {
		return incompleteQuotientAndRemaider;
	}

	public void setIncompleteQuotientAndRemainder(int incompleteQuotient, int remainder) {
		DivisionStep step = new DivisionStep();
		step.setIncompleteQuotient(incompleteQuotient);
		step.setRemainder(remainder);
		this.incompleteQuotientAndRemaider.add(step);
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
		if (incompleteQuotientAndRemaider == null) {
			if (other.incompleteQuotientAndRemaider != null)
				return false;
		} else if (!incompleteQuotientAndRemaider.equals(other.incompleteQuotientAndRemaider))
			return false;
		if (result != other.result)
			return false;
		return true;
	}

}
