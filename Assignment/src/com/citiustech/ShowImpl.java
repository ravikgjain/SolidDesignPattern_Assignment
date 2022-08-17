package com.citiustech;
import java.util.List;

public class ShowImpl implements ShowDetails{

	public List<Show> displayAllShows() {
		return ShowManagerImpl.shows;
	}
	
}

