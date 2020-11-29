package main.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.model.Showtime;

public class ShowtimeController {

	private DBController DB;

	public ShowtimeController() {
		DB = DBController.getInstance();
	}

	public ArrayList<Showtime> getShowtimes() {
		ResultSet r = DB.query("SELECT * FROM Showtime");
		ArrayList<Showtime> showtimeList = new ArrayList<Showtime>();
		try {
			while (r.next()) {
				Showtime showtime = new Showtime(r.getInt("showtimeId"), r.getString("time"), r.getInt("movieId"));
				showtimeList.add(showtime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return showtimeList;
	}

	public Showtime addShowtime(String time, int movieId) {
		int showtimeId = DB.executeReturnKey("INSERT INTO Showtime (time, movieId) VALUES (?, ?)", time, movieId);
		if (showtimeId == -1)
			return null;
		return new Showtime(showtimeId, time, movieId);
	}

	// gets Showtime for showtimeId
	public Showtime getShowtime(int showtimeId) {
		ResultSet r = DB.query("SELECT * FROM Showtime WHERE showtimeId = ?", showtimeId);
		try {
			if (r.next()) {
				return new Showtime(r.getInt("showtimeId"), r.getString("time"), r.getInt("movieId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public static void main(String[] args) { // a few tests... ShowtimeController
	 * sc = new ShowtimeController(); MovieController mc = new MovieController();
	 * Movie m = mc.addMovie("test movie"); sc.addShowtime("Wednesday evening",
	 * m.getMovieId()); ArrayList<Showtime> sl = sc.getShowtimes(); for(int i = 0; i
	 * < sl.size(); i++) { System.out.println(sl.toString()); } }
	 */
}
