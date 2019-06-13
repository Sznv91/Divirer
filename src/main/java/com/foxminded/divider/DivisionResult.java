package com.foxminded.divider;

public class DivisionResult {
	private int[] dividend;
	private int divider;
	private int[] answer;
	private int[] upperResults;
	private int[] downerResults;

	public DivisionResult(int[] divident, int divider) {
		super();
		this.dividend = divident;
		this.divider = divider;
	}

	public int[] getDivident() {
		return dividend;
	}

	public int getDivider() {
		return divider;
	}

	public int[] getUpperResults() {
		return upperResults;
	}

	public void setUpperResults(int[] upperResults) {
		this.upperResults = upperResults;
	}

	public int[] getDownerResults() {
		return downerResults;
	}

	public void setDownerResults(int[] downerResults) {
		this.downerResults = downerResults;
	}

	public int[] getAnswer() {
		return answer;
	}

	public void setAnswer(int[] answer) {
		this.answer = answer;
	}
}
