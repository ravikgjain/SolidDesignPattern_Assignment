package com.citiustech;

public class SeatsNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = -5857826357929796111L;

	public SeatsNotAvailableException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
