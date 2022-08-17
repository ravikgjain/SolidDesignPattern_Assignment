package com.citiustech;

public class InvalidMovieIdOrNoOfTickets extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1616775023343475422L;

	public InvalidMovieIdOrNoOfTickets(String str) {
		super(str);
	
	}
}
