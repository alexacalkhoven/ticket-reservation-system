package model;

import java.util.ArrayList;

public class User {

	ArrayList<Ticket> tickets;
	
	
	public User() {
		
		
	}
	
	//getters and setters
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}


	//other functions 
	Ticket buyTicket(Seat seat, Showtime showtime) {
		tickets.add(new Ticket(seat, showtime));
	}
	
	void selectSeat(Seat seat) {	
		seat.claimSeat();
	}
	
	void cancelTicket(Ticket t) {
		ArrayList.remove(t);
		
	}
	
	
	
}
