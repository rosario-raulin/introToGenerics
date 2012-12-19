package de.raulin.rosario.introductionToExceptions;

public class NegativeValueException extends Exception {

	private static final long serialVersionUID = 1L;

	private final int value;
	
	public NegativeValueException(final int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
