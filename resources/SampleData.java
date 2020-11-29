package resources;

import main.controller.MovieController;
import main.controller.ShowtimeController;
import main.controller.SeatController;

import java.util.ArrayList;

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

	public static void addMoviesAndShowtimes() {
		MovieController mc = new MovieController();
		ShowtimeController sc = new ShowtimeController();

		Movie m1 = mc.addMovie("The Incredibles");
		Showtime s1a = sc.addShowtime("Tuesday December 1 2020, 7pm", m1.getMovieId());
		addSeats(s1a.getShowtimeId(), "A");
		Showtime s1b = sc.addShowtime("Tuesday December 1 2020, 9pm", m1.getMovieId());
		addSeats(s1b.getShowtimeId(), "B");
		Showtime s1c = sc.addShowtime("Thursday December 3 2020, 7pm", m1.getMovieId());
		addSeats(s1c.getShowtimeId(), "A");
		Showtime s1d = sc.addShowtime("Thursday December 3 2020, 9pm", m1.getMovieId());
		addSeats(s1d.getShowtimeId(), "B");

		Movie m2 = mc.addMovie("Mean Girls");
		Showtime s2a = sc.addShowtime("Wednesday December 2 2020, 5pm", m2.getMovieId());
		addSeats(s2a.getShowtimeId(), "C");
		Showtime s2b = sc.addShowtime("Thursday December 3 2020, 9pm", m2.getMovieId());
		addSeats(s2b.getShowtimeId(), "C");

		Movie m3 = mc.addMovie("The Grinch");
		Showtime s3a = sc.addShowtime("Wednesday December 2 2020, 1pm", m3.getMovieId());
		addSeats(s3a.getShowtimeId(), "A");
		Showtime s3b = sc.addShowtime("Wednesday December 2 2020, 3pm", m3.getMovieId());
		addSeats(s3b.getShowtimeId(), "B");
		Showtime s3c = sc.addShowtime("Friday December 4 2020, 4pm", m3.getMovieId());
		addSeats(s3c.getShowtimeId(), "A");

		Movie m4 = mc.addMovie("Clueless");
		Showtime s4a = sc.addShowtime("Tuesday December 1 2020, 5pm", m4.getMovieId());
		addSeats(s4a.getShowtimeId(), "D");
		Showtime s4b = sc.addShowtime("Wednesday December 2 2020, 7pm", m4.getMovieId());
		addSeats(s4b.getShowtimeId(), "D");
		Showtime s4c = sc.addShowtime("Thursday December 3 2020, 4pm", m4.getMovieId());
		addSeats(s4c.getShowtimeId(), "D");
		Showtime s4d = sc.addShowtime("Friday December 4 2020, 9pm", m4.getMovieId());
		addSeats(s4d.getShowtimeId(), "D");

		Movie m5 = mc.addMovie("Avengers: Endgame");
		Showtime s5a = sc.addShowtime("Tuesday December 1 2020, 1pm", m5.getMovieId());
		addSeats(s5a.getShowtimeId(), "E");
		Showtime s5b = sc.addShowtime("Friday December 4 2020, 1pm", m5.getMovieId());
		addSeats(s5b.getShowtimeId(), "E");
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
				"Avengers: Endgame is out now! Book tickets today. 2 seats reserved specially for Registered Users.");
		addPromotionEmailsToUsers(
				"Clueless is out now! Book tickets today. 2 seats reserved specially for Registered Users.");
		addPromotionEmailsToUsers(
				"New movie is coming out tomorrow. Keep an eye out on your inbox for more information soon.");

	}

	public static void addPromotionEmailsToUsers(String message) {
		EmailController ec = new EmailController();
		Email e = ec.addEmail(1, message);
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
