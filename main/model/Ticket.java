package main.model;


public class Ticket {

	private int ticketId;
	private int seatId;
	private int showtimeId;
	private int paymentId;
	private Time timePurchased;
	

	
	public Ticket() {
		
	}

	public Ticket(int ticketId, int seatId, int showtimeId, int paymentId, Time timePurchased) {
		this.ticketId = ticketId;
		this.seatId = seatId;
		this.showtimeId = showtimeId;
		this.paymentId = paymentId;
		this.timePurchased = timePurchased;

	}

	//cancel ticket at theatre by freeing the seat corresponding to the ticket and getting a refund receipt
//	public void cancelTicket() {
//		
////		
////		ArrayList<Showtime> st=theater.getShowtimes();
////		//find showtime of ticket in db
////		for(int i=0; i<st.size();i++) {
////			if(st.get(i).showtimeId==this.showtimeId) {
////				ArrayList<Seat> s =st.get(i).getSeats();
////				//find corresponding seat 
////				for(int j=0; j< s.size(); j++) {
////					//change seat state
////					if(s.get(j).seatId==seatId) {
////						s.get(j).freeSeat();
////					}
////					//change showtime state
////					theater.setShowtimes(st);
////					receipt.createRefundReceipt(); //get refund for ticket
////				}
////			}
////
////
////		}
//
//
//	}
//
//	//book a ticket for a specific showtime 
//	public void payForTicket(Theater theater) {
////		ArrayList<Showtime> st=theater.getShowtimes();
////		//find showtime of ticket in db
////		for(int i=0; i<st.size();i++) {
////			if(st.get(i).showtimeId==this.showtimeId) {
////				ArrayList<Seat> s =st.get(i).getSeats();
////				//find corresponding seat 
////				for(int j=0; j< s.size(); j++) {
////					//change seat state
////					if(s.get(j).seatId==seatId) {
////						s.get(j).claimSeat();
////					}
////					//change showtime state
////					theater.setShowtimes(st);
////					payment.makePaymentToTheatre(user);//make payment for ticket
////					if(payment.isComplete==true) //check to see payment went through
////						receipt.emailReceiptAndTicket(user); //get recepit for payment with ticket
////				}
////			}
////		}
//	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Time getTimePurchased() {
		return timePurchased;
	}

	public void setTimePurchased(Time timePurchased) {
		this.timePurchased = timePurchased;
	}
	

}
