package main.model;

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

	// getters and setters
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
	
	/*
	 * Handled in the controller
	// other functions
	Ticket buyTicket(Seat seat, Showtime showtime) {
		tickets.add(new Ticket(seat, showtime));
	}

	void selectSeat(Seat seat) {
		seat.claimSeat();
	}

	void cancelTicket(Ticket t) {
		ArrayList.remove(t);

	}
	*/

}
