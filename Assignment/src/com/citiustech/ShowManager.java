package com.citiustech;
import java.util.List;

public interface ShowManager {

	public void populate(Show show) ;

	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats)
			throws UnknownShowException, SeatsNotAvailableException, InvalidSeatNumberException;

}
