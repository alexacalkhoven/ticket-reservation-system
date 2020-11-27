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


	

	@Override
	public String toString() {
		return "ticketId: " + ticketId + "seatId: " + seatId + "showtimeId:" + showtimeId + "paymentId:"
				+ paymentId + "timePurchased:" + timePurchased.toString() ;
	}

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
