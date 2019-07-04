package com.foxminded.divider;

public class IncompleteQuotientAndRemaider {
	private int incompleteQuotient;
	private int remainder;

	public int getIncompleteQuotient() {
		return incompleteQuotient;
	}

	public void setIncompleteQuotient(int incompleteQuotient) {
		this.incompleteQuotient = incompleteQuotient;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncompleteQuotientAndRemaider other = (IncompleteQuotientAndRemaider) obj;
		if (incompleteQuotient != other.incompleteQuotient)
			return false;
		if (remainder != other.remainder)
			return false;
		return true;
	}

}
