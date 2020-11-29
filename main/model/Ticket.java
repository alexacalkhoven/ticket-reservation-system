package main.model;

import java.util.ArrayList;
import java.util.Date;

import main.controller.DBController;
import main.controller.EmailController;
import main.controller.TicketController;
import main.controller.UserController;
import main.controller.PaymentController;
import main.controller.SeatController;
import main.controller.MovieController;
import main.controller.ShowtimeController;


public class Ticket {

	private int ticketId;
	private int seatId;
	private int showtimeId;
	private int paymentId;
	private Date timePurchased;

	public Ticket() {

	}

	public Ticket(int ticketId, int seatId, int showtimeId, int paymentId, Date timePurchased) {
		this.ticketId = ticketId;
		this.seatId = seatId;
		this.showtimeId = showtimeId;
		this.paymentId = paymentId;
		this.timePurchased = timePurchased;

	}

	@Override
	public String toString() {
		return "ticketId: " + ticketId + " seatId: " + seatId + " showtimeId:" + showtimeId + " paymentId:" + paymentId
				+ " timePurchased:" + timePurchased.toString();
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

	public Date getTimePurchased() {
		return timePurchased;
	}

	public void setTimePurchased(Date timePurchased) {
		this.timePurchased = timePurchased;
	}

	public boolean validCancel() {

		long timeDifMS = new java.util.Date().getTime() - timePurchased.getTime(); // get current time in ms and
																					// subtract purchase time in ms.

		int timeDifHrs = (int) timeDifMS / 3600000; // get the integer time difference in hours

		if (timeDifHrs >= 72) {
			return true;
		}

		return false;

	}

	public void cancelTicket(String username, int type) {

		TicketController tc = new TicketController();

		EmailController ec = new EmailController();

		PaymentController pc = new PaymentController();

		// check if cancellation is valid
		if (validCancel() == false) {
			return;
		}

		// Format Messaging for email:

		String message = "";
		Date currentDate = new Date();
		Payment payment = pc.getPayment(paymentId);
		if (payment == null) {
			System.err.println("Error in retrieving payment information for refund.");
		}

		// rough form of what it should like. Next version should have the actual amount
		// refunded by using payment id to get amount.

		if (type == 1) { // if it is a registered user generate a return receipt email for a Ru - no 15%
							// deduction

			message = "Receipt for: " + username + "\n";
			message += "100% movie credit refund issued \n";
			message += "Ticket ID: " + ticketId + " seat ID: " + seatId + " Showtime ID: " + showtimeId + "Payment ID: "
					+ paymentId + "\n";
			message += "Date Purchased: " + timePurchased.getMonth() + "/" + timePurchased.getDate() + "/"
					+ (timePurchased.getYear() + 1900) + "\n";
			message += "Date Refunded: " + currentDate.getMonth() + "/" + currentDate.getDate() + "/"
					+ (currentDate.getYear() + 1900) + "\n";
			message += "You will be refunded $" + payment.amount + " as a movie credit. Show this email to redeem.";

		} else { // user is not RU so no discount
			message = "Receipt for: " + username + "\n";
			message += "85% movie credit refund issued \n"; // 100% minus 15% fee
			message += "Ticket ID: " + ticketId + " seat ID: " + seatId + " Showtime ID: " + showtimeId + "Payment ID: "
					+ paymentId + "\n";
			message += "Date Purchased: " + timePurchased.getMonth() + "/" + timePurchased.getDate() + "/"
					+ (timePurchased.getYear() + 1900) + "\n";
			message += "Date Refunded: " + currentDate.getMonth() + "/" + currentDate.getDate() + "/"
					+ (currentDate.getYear() + 1900);
			message += "You will be refunded $" + 0.85 * payment.amount
					+ " as a movie credit. Show this email to redeem.";

		}

		// set up email
		Email email = ec.addEmail(0, message);

		ec.addEmailToUser(username, email.getEmailId()); // add the email to the user

		tc.cancelTicket(ticketId); // call the ticket controller to cancel the ticket. Should also free up the
									// occupied seat.

	}

	public void makePurchaseReceipt(String username) {

		EmailController ec = new EmailController();

		PaymentController pc = new PaymentController();
		
		SeatController sc = new SeatController();
		
		ShowtimeController stc = new ShowtimeController();
		
		MovieController mc = new MovieController();

		// Format Messaging for email:

		String message = "";
		Payment payment = pc.getPayment(paymentId);
		Seat seat = sc.getSeat(seatId);
		Showtime st = stc.getShowtime(showtimeId);
		Movie movie = mc.getMovie(st.getMovieId());
		
		if (payment == null) {
			System.err.println("Error in retrieving payment information for purchase.");
		}

		message = "Receipt for: " + username + "\n";
		message += "Movie ticket purchased \n";
		message += "Ticket ID: " + ticketId + " seat ID: " + seatId + " Showtime ID: " + showtimeId + "Payment ID: "
				+ paymentId + "\n";
		//message += "Seat: row " + seat.getRow() + " column " + seat.getCol() + ", screen " + seat.getScreen() + "\n"; // COMMENT BACK IN WHEN WE HAVE SETTERS AND GETTERS
		message += "Movie: " + movie.getName() + "\n";
		message += "Time: " + st.getTime() + "\n";
		message += "Date Purchased: " + timePurchased.getMonth() + "/" + timePurchased.getDate() + "/"
				+ (timePurchased.getYear() + 1900) + "\n";
		message += "Cost: $" + payment.amount + ". Show this email as your ticket.\n";

		// set up email
		Email email = ec.addEmail(0, message);

		ec.addEmailToUser(username, email.getEmailId()); // add the email to the user
	}

}
