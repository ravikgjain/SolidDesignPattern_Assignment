package com.citiustech;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookTickets {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		List<Show> list = ShowManagerImpl.shows;
		ShowManagerImpl abc = new ShowManagerImpl();

		Scanner s = new Scanner(new File("booking.txt"));
		while (s.hasNextLine()) {
		String st = s.nextLine();
		String[] split = st.split(",");
		String showName = split[0];
		String showTime = split[1];
		String seatsAvailable = split[2];


		abc.populate(new Show(showName, showTime, Integer.valueOf(seatsAvailable)));
		}
		s.close();

		list = new ShowImpl().displayAllShows();
		list.stream().sorted(Comparator.comparing(Show::getShowName)).forEach(x -> System.out.println(x));

		try {
			abc.bookShow(list,"Bramhastra","10:30",12);
			list = ShowManagerImpl.shows;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
