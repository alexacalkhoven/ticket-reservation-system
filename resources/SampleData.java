package resources;

import main.controller.MovieController;
import main.controller.ShowtimeController;
import main.controller.SeatController;

import java.util.ArrayList;
import java.util.Date;

import main.controller.EmailController;
import main.controller.UserController;
import main.model.Movie;
import main.model.RegisteredUser;
import main.model.Seat;
import main.model.Showtime;
import main.model.Email;

public class SampleData {

	public static void addSampleData() {
		addMoviesAndShowtimes();
		addPromotionEmails();
	}

	@SuppressWarnings("deprecation")
	public static void addMoviesAndShowtimes() {
		MovieController mc = new MovieController();
		ShowtimeController sc = new ShowtimeController();
		//sc.clearShowtimes();
		//mc.clearMovies();
		
		Date d1 = new Date(2020 - 1901, 11, 1, 19, 0);
		Date d2 = new Date(2020 - 1901, 11, 1, 21, 0);
		Date d3 = new Date(2020 - 1901, 11, 3, 19, 0);
		Date d4 = new Date(2020 - 1901, 11, 3, 21, 0);
		Date d5 = new Date(2020 - 1901, 11, 1, 13, 0);
		Date d6 = new Date(2020 - 1901, 11, 2, 17, 0);
		Date d7 = new Date(2020 - 1901, 11, 2, 13, 0);
		Date d8 = new Date(2020 - 1901, 11, 2, 15, 0);
		
		Movie m1 = mc.addMovie("The Incredibles");
		Showtime s1a = sc.addShowtime(new java.sql.Timestamp(d1.getTime()), m1.getMovieId());
		if(s1a != null) addSeats(s1a.getShowtimeId(), "A");
		Showtime s1b = sc.addShowtime(new java.sql.Timestamp(d2.getTime()), m1.getMovieId());
		if(s1b != null) addSeats(s1b.getShowtimeId(), "B");
		Showtime s1c = sc.addShowtime(new java.sql.Timestamp(d3.getTime()), m1.getMovieId());
		if(s1c != null) addSeats(s1c.getShowtimeId(), "A");
		Showtime s1d = sc.addShowtime(new java.sql.Timestamp(d4.getTime()), m1.getMovieId());
		if(s1d != null) addSeats(s1d.getShowtimeId(), "B");

		Movie m2 = mc.addMovie("Mean Girls");
		Showtime s2a = sc.addShowtime(new java.sql.Timestamp(d6.getTime()), m2.getMovieId());
		if(s2a != null) addSeats(s2a.getShowtimeId(), "C");
		Showtime s2b = sc.addShowtime(new java.sql.Timestamp(d4.getTime()), m2.getMovieId());
		if(s2b != null) addSeats(s2b.getShowtimeId(), "C");

		Movie m3 = mc.addMovie("The Grinch");
		Showtime s3a = sc.addShowtime(new java.sql.Timestamp(d7.getTime()), m3.getMovieId());
		if(s3a != null) addSeats(s3a.getShowtimeId(), "A");
		Showtime s3b = sc.addShowtime(new java.sql.Timestamp(d8.getTime()), m3.getMovieId());
		if(s3b != null) addSeats(s3b.getShowtimeId(), "B");
		Showtime s3c = sc.addShowtime(new java.sql.Timestamp(d2.getTime()), m3.getMovieId());
		if(s3c != null) addSeats(s3c.getShowtimeId(), "A");

		Movie m4 = mc.addMovie("Clueless");
		Showtime s4a = sc.addShowtime(new java.sql.Timestamp(d1.getTime()), m4.getMovieId());
		if(s4a != null) addSeats(s4a.getShowtimeId(), "D");
		Showtime s4b = sc.addShowtime(new java.sql.Timestamp(d3.getTime()), m4.getMovieId());
		if(s4b != null) addSeats(s4b.getShowtimeId(), "D");
		Showtime s4c = sc.addShowtime(new java.sql.Timestamp(d4.getTime()), m4.getMovieId());
		if(s4c != null) addSeats(s4c.getShowtimeId(), "D");
		Showtime s4d = sc.addShowtime(new java.sql.Timestamp(d8.getTime()), m4.getMovieId());
		if(s4d != null) addSeats(s4d.getShowtimeId(), "D");

		Movie m5 = mc.addMovie("Avengers: Endgame");
		Showtime s5a = sc.addShowtime(new java.sql.Timestamp(d5.getTime()), m5.getMovieId());
		if(s5a != null) addSeats(s5a.getShowtimeId(), "E");
		Showtime s5b = sc.addShowtime(new java.sql.Timestamp(d6.getTime()), m5.getMovieId());
		if(s5b != null) addSeats(s5b.getShowtimeId(), "E");
	}

	public static void addSeats(int showtimeId, String theatre) {
		SeatController sc = new SeatController();
		for (int i = 0; i < Constants.NUM_ROWS; i++) {
			for (int j = 0; j < Constants.NUM_COLS; j++) {
				int type = 0; 
				if((i == 0 && j == 0) || (i == 0 && j == 1)) type = 1;
				Seat added = sc.addSeat(i, j, theatre, false, type);
				sc.addSeatToShowtime(showtimeId, added.getSeatId());
			}
		}
	}

	public static void addPromotionEmails() {
		addPromotionEmailsToUsers(
				"\nAvengers: Endgame is out now! Book tickets today. 2 seats reserved specially for Registered Users.");
		addPromotionEmailsToUsers(
				"\nClueless is out now! Book tickets today. 2 seats reserved specially for Registered Users.");
		addPromotionEmailsToUsers(
				"\nNew movie is coming out tomorrow. Keep an eye out on your inbox for more information soon.");

	}

	public static void addPromotionEmailsToUsers(String message) {
		EmailController ec = new EmailController();
		Email e = ec.addEmail(1, message);
		if(e == null) return;
		UserController uc = new UserController();
		ArrayList<RegisteredUser> ruList = uc.getRegisteredUsers();
		for (int i = 0; i < ruList.size(); i++) {
			ec.addEmailToUser(ruList.get(i).getUsername(), e.getEmailId());
		}
	}

}

/*
 * TODO: 
 * Link to GUI. 
 * Go through the original document and make sure all functionalities are achieved (should make
 * a pay fee function for RUs).
 * DOCUMENT
 */
