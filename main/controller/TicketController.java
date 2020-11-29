package main.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import main.model.Ticket;

public class TicketController {

	private DBController DB;

	public TicketController() {
		DB = DBController.getInstance();
	}

	// creates new ticket in database and return it as a ticket object
	public Ticket addTicket(int seatId, int showtimeId, int paymentId) {
		// note: ticketId is automatically generated
		// timePurchased will be set to current time/date (date and time)
		Date date = new Date();
		int ticketId = DB.executeReturnKey(
				"INSERT INTO Ticket (seatId, showtimeId, paymentId, timePurchased) VALUES (?, ?, ?, ?)", seatId,
				showtimeId, paymentId, new java.sql.Timestamp(date.getTime()));
		if (ticketId == -1)
			return null;
		return new Ticket(ticketId, seatId, showtimeId, paymentId, date);
	}

	// Returns a list of tickets associated with a user.
	public ArrayList<Ticket> getTickets(String username) {
		ResultSet r = DB.query("SELECT ticketId FROM UserToTicket WHERE username = ?", username);
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		try {
			while (r.next()) {
				int ticketId = r.getInt("ticketId");
				ResultSet t = DB.query("SELECT * FROM Ticket WHERE ticketId = ?", ticketId);
				t.next();
				Ticket ticket = new Ticket(t.getInt("ticketId"), t.getInt("seatId"), t.getInt("showtimeId"),
						t.getInt("paymentId"), t.getDate("timePurchased"));
				ticketList.add(ticket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	// getTicket(ticketId)

	/**
	 * Inserts a row to UserToTicket, assigning a ticket to a user.
	 * 
	 * @param username FK of user to be assigned ticket.
	 * @param ticketId FK of ticket being assigned.
	 * @return True if successful, False if failed.
	 */
	public boolean assignTicketToUser(String username, int ticketId) {
		int rows = DB.execute("INSERT INTO UserToTicket (username, ticketId) VALUES (?, ?)", username, ticketId);
		if (rows != 1)
			return false;
		return true;
	}

	/**
	 * Deletes ticket from Ticket table. Cascade deletes all entries with ticketId
	 * in UserToTicket as well.
	 * 
	 * @param ticketId ticket to be deleted.
	 * @return true is successful, false if error.
	 */
	public boolean cancelTicket(int ticketId) {
		int rows = DB.execute("DELETE FROM Ticket WHERE ticketId = ?", ticketId);
		if (rows != 1)
			return false;
		return true;
	}

	// gets Ticket for ticketId
	public Ticket getTicket(int ticketId) {
		ResultSet r = DB.query("SELECT * FROM Ticket WHERE ticketId = ?", ticketId);
		try {
			if (r.next()) {
				return new Ticket(r.getInt("ticketId"), r.getInt("seatId"), r.getInt("showtimeId"), r.getInt("paymentId"), r.getDate("timePurchased"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public static void main(String[] args) { // a few tests... TicketController
	 * sc = new TicketController(); Ticket t = sc.addTicket(1, 1, 1);
	 * sc.assignTicketToUser("alexa12", t.getTicketId()); Ticket t2 =
	 * sc.addTicket(1, 3, 1); sc.assignTicketToUser("alexa12", t2.getTicketId());
	 * ArrayList<Ticket> tl = sc.getTickets("alexa12"); for(int i = 0; i <
	 * tl.size(); i++) { System.out.println(tl.get(i).toString()); }
	 * sc.cancelTicket(t2.getTicketId());
	 * System.out.println("After cancellation.."); ArrayList<Ticket> tl2 =
	 * sc.getTickets("alexa12"); for(int i = 0; i < tl2.size(); i++) {
	 * System.out.println(tl2.get(i).toString()); } }
	 */
}
