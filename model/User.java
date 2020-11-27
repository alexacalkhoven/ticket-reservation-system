package model;

import java.util.ArrayList;

public class User {

	ArrayList<Ticket> tickets;
	int type; // 0 = OU, 1 = RU
	String username;
	
	public User() {
		
		
	}
	
	public User(int type, String username) {
		this.type = type;
		this.username = username;
	}
	
	
	
	//getters and setters
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//other functions 
	Ticket buyTicket(int ticketId, int seatId, int showtimeId, int paymentId, Time timePurchased) {
		Ticket t = new Ticket(ticketId, seatId, showtimeId, paymentId, timePurchased);
		tickets.add(t);
		return t;
	}
	
	void selectSeat(Seat seat) {	
		seat.claimSeat();
	}
	
	void cancelTicket(Ticket t) {
		tickets.remove(t);
		
	}
	
	
	
}
