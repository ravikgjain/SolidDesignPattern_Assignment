package com.citiustech;

public class BookMyMovie {

	private Integer movieId;
	private Integer noOfTickets;
	private Double discount;
	private Double totalAmount;
	
	public BookMyMovie(Integer movieId, Integer noOfTickets, Double discount, Double totalAmount) {
		super();
		this.movieId = movieId;
		this.noOfTickets = noOfTickets;
		this.discount = discount;
		this.totalAmount = totalAmount;
	}

	public BookMyMovie(Integer movieId, Integer noOfTickets) {
		super();
		this.movieId = movieId;
		this.noOfTickets = noOfTickets;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(Integer noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Double calculateDiscount(Integer noOfTickets, Integer movieId){
		Double discount =1d ;
		if((noOfTickets < 5) && (movieId == 101 || movieId == 102 || movieId == 103)) {
			discount = 1d;
		} else if((noOfTickets >= 5 && noOfTickets < 10) && (movieId == 101 || movieId == 103)) {
			discount = 15/100d;
		} else if((noOfTickets >= 10 && noOfTickets <= 15) && (movieId == 101 || movieId == 103)) {
			discount = 20/100d;
		} else if((noOfTickets >= 5 && noOfTickets < 10) && (movieId == 102)) {
			discount = 10/100d;
		} else if((noOfTickets >= 10 && noOfTickets <= 15) && (movieId == 102)) {
			discount = 15/100d;
		}
		return discount;
	}
	
	public Double calculateTicketAmount(Integer movieId, Integer noOfTickets){
		Integer baseFairfor101 = 120;
		Integer baseFairfor102 = 170;
		Integer baseFairfor103 = 150;
		Double totalTicketAmt = null;

				//logic for calculate Discount
				Double calculatedDiscount = calculateDiscount(noOfTickets, movieId);	
		
				//logic for calculate total ticket amount
				if(movieId == 101) {
					totalTicketAmt = baseFairfor101 * noOfTickets - ((baseFairfor101 * noOfTickets) * calculatedDiscount);
				} else if(movieId == 102) {
					totalTicketAmt = baseFairfor102 * noOfTickets - ((baseFairfor102 * noOfTickets) * calculatedDiscount);
				} else {
					totalTicketAmt = baseFairfor103 * noOfTickets - ((baseFairfor103 * noOfTickets) * calculatedDiscount);
				}
				
			
		return totalTicketAmt;
	}
	
	public static void main(String[] args) {
		
		BookMyMovie object1 = new BookMyMovie(101,5);
		
		try {
			if((object1.getMovieId() >= 101 && object1.getMovieId() <= 103) && (object1.getNoOfTickets() >0) ) {
				Double calculatedTicketAmount = object1.calculateTicketAmount(object1.getMovieId(), object1.getNoOfTickets());
				System.out.println("for BookMyMovie object1 : Total Amount for Booking : "+calculatedTicketAmount);
			}else {
				throw new InvalidMovieIdOrNoOfTickets("\n\n"
						+ "Sorry Invalid Movie Id OR Invalid Seats \n"
						+ "Please Check the Movie Id and enter once again \n\n");
			}
			
		}catch (InvalidMovieIdOrNoOfTickets e) {
			e.printStackTrace();
		}
		
	}		
}