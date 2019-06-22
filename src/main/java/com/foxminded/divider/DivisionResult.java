package com.foxminded.divider;

import java.util.ArrayList;

public class DivisionResult {
	private int dividend;
	private int[] dividendMassive;
	private int divider;
	private ArrayList<Integer> answer;
	private ArrayList<Integer> upperResults;
	private ArrayList<Integer> downerResults;

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

	public ArrayList<Integer> getUpperResults() {
		return upperResults;
	}

	public void setUpperResults(ArrayList<Integer> upperResults) {
		this.upperResults = upperResults;
	}

	public ArrayList<Integer> getDownerResults() {
		return downerResults;
	}

	public void setDownerResults(ArrayList<Integer> downerResults) {
		this.downerResults = downerResults;
	}

	public ArrayList<Integer> getAnswer() {
		return answer;
	}

	public void setAnswer(ArrayList<Integer> answer) {
		this.answer = answer;
	}

	public int[] getDividendMassive() {
		return dividendMassive;
	}

	public void setDividendMassive(int[] dividendMassive) {
		this.dividendMassive = dividendMassive;
	}
	
}
