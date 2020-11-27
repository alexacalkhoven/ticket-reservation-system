package main.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import main.model.Seat;

public class SeatController {

	private DBController DB;
	
	public SeatController() {
		DB = DBController.getInstance();
	}
	
	//getSeats(showtimeId): Seat []
	/*
	public ArrayList<Seat> getSeats(int showtimeId){
		ResultSet r = DB.query("SELECT seatId FROM ShowtimeToSeat WHERE showtimeId = ?", showtimeId);
		ArrayList<Seat> seatList = new ArrayList<Seat>();
		try {
			while(r.next()) {
				int seatId = r.getInt("seatId");
				ResultSet s = DB.query("SELECT * FROM Seat WHERE seatId = ?", seatId);
				Seat seat = new Seat(s.getInt("seatId"), s.getInt("rowNumber"), s.getInt("colNumber"), s.getString("screen"), s.getBoolean("isTaken"), s.getInt("seatType"));
				seatList.add(seat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seatList;
	}
	*/
	
	// getSeat(seatId)?
	
	/**
	 * Determines if a seat with seatId is valid. First checks that it exists. Then checks if it's taken. Lastly checks if the username entered is valid to purchase the seat or not.
	 * 
	 * Note: may be beneficial to break these down into separate functions.
	 * 
	 * @param username PK of user.
	 * @param seatId points to the seat that we want to check.
	 * @return true if seat is valid, false if not.
	 */
	public boolean isValidSeat(String username, int seatId) {
		// check first that the seat exists
		ResultSet countResult = DB.query("SELECT COUNT(*) AS count FROM Seat WHERE Seat.seatId = ?", seatId);
		try {
			countResult.next();
			int seatCount = countResult.getInt("count");
			if(seatCount != 1) return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// check if seat is taken
		ResultSet seatResult = DB.query("SELECT * FROM Seat WHERE Seat.seatId = ?", seatId);
		try {
			seatResult.next();
			boolean taken = seatResult.getBoolean("isTaken");
			if(taken) return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// check if seat is the correct type
		// seatType = 0 --> normal seat
		// seatType = 1 --> reserved seat
		// userType = 0 --> OU
		// userType = 1 --> RU
		ResultSet seatTypeResult = DB.query("SELECT seatType FROM Seat WHERE Seat.seatId = ?", seatId);
		ResultSet userTypeResult = DB.query("SELECT userType FROM User WHERE User.username = ?", username);
		try {
			seatTypeResult.next();
			userTypeResult.next();
			int seatType = seatTypeResult.getInt("seatType");
			if(seatType == 0) return true;
			int userType = userTypeResult.getInt("userType");
			if(userType == 0) return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Changes status of seat from false (not taken) to true (taken). If already taken, does nothing.
	 * 
	 * @param seatId seat to update.
	 */
	public void markSeatAsTaken(int seatId) {
		DB.execute("UPDATE seat SET isTaken = 1 WHERE seatId = ?", seatId);
	}

	/*
	public static void main(String[] args) {
		// a few tests...
		SeatController sc = new SeatController();
		System.out.println(sc.DB.execute("INSERT INTO seat (rowNumber, colNumber, screen, isTaken, seatType) VALUES (?, ?, ?, ?, ?)", 1, 1, "A", 0, 0));
		System.out.println(sc.isValidSeat("alexa1234", 1));
		sc.markSeatAsTaken(2);
	}
	*/
}
