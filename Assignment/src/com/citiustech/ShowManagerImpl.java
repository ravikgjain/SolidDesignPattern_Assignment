package com.citiustech;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShowManagerImpl implements ShowManager{
	public static volatile List<Show> shows = populateShows();

	@Override
	public void populate(Show show) {
		shows.add(show);
	}

	@Override
	public void bookShow(List<Show> showList, String showName, String showTime, int noOfSeats)
			throws UnknownShowException, SeatsNotAvailableException, InvalidSeatNumberException {
		boolean name = false;
		boolean time = false;
		boolean seats = false;
		String test = "";
		int AvailableSeats = 0;
		String movie = "";
		for (Show show : shows) {
			if (show.getShowName().equalsIgnoreCase(showName)) {			
				name = true;
				AvailableSeats = show.getSeatsAvailable();
				movie = show.getShowName();
				if (show.getShowTime().equals(showTime)) {
					time = true;
					
					if(noOfSeats <= 0) {
						test = "negative";
						break;
					}
					
					if(show.getSeatsAvailable() >= noOfSeats) {
						show.setSeatsAvailable(show.getSeatsAvailable() - noOfSeats);
						seats = true;
						
						doChangesInTextFIle(showName,showTime,noOfSeats,AvailableSeats);
						 System.out.println("Show ticket booked successfully");
						 System.out.println("Remaining seats for : "+movie+" -- " + show.getSeatsAvailable());
					}	
					
				} 
				break;
			}
		}
		
		if (!name) {
			throw new UnknownShowException("Show " + showName + " is not available");
		} else if(!time) {
			throw new UnknownShowException("Show " + showName + " is not available " + showTime);
		} else if (test.equalsIgnoreCase("negative")) {
			throw new InvalidSeatNumberException("\n\nInvalid seat number=> "+ noOfSeats+"\n");
		}else if(!seats) {
			throw new SeatsNotAvailableException(
					"\n\nSorry.. Available seats=> "+AvailableSeats+" empty number of seats \n you have entered "+noOfSeats+" for the show "+movie+"\n");
		}
	}

	private void doChangesInTextFIle(String showName, String showTime, int noOfSeats, int AvailableSeats) {
		 try {
			 Scanner sc = new Scanner(new File("booking.txt"));
			 
			 StringBuffer strbuffer = new StringBuffer();
		      
		      while (sc.hasNextLine()) {
		         strbuffer.append(sc.nextLine()+System.lineSeparator());
		      }
		      String fileContents = strbuffer.toString();
		      sc.close();

		      String s1 = showName+","+showTime+","+AvailableSeats;
		      String s2 = showName+","+showTime+","+(AvailableSeats-noOfSeats);
		      
		      fileContents = fileContents.replaceAll(s1, s2);
		      
		      @SuppressWarnings("resource")
			FileWriter fileWriter = new FileWriter("booking.txt");

		      fileWriter.append(fileContents);
		      fileWriter.flush();
		      
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private static List<Show> populateShows() {
		return new LinkedList() {
			{

			}
		};
	}
}
