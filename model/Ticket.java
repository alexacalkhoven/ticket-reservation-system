package model;

import java.util.ArrayList;
import java.util.Date;

import main.controller.DBController;
import main.controller.EmailController;
import main.controller.TicketController;
import main.controller.UserController;

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
		
		
		long timeDifMS = new java.util.Date().getTime() - timePurchased.getTime(); //get current time in ms and subtract purchase time in ms.
		
		int timeDifHrs = (int) timeDifMS / 3600000; //get the integer time difference in hours 
		
		
		if (timeDifHrs >=72) {
			return true;
		}
		
		
		return false;
		
	}
	
	
	public void cancelTicket(String username, int type) {
		
		
		TicketController tc = new TicketController();
		
		EmailController ec = new EmailController();
		
	
		//check if cancellation is valid 
		if(validCancel() == false) {
			return;
		}	
			
		
		//Format Messaging for email: 
		
	
		String message = "";
		Date currentDate = new Date();
		
		//rough form of what it should like. Next version should have the actual amount refunded by using payment id to get amount. 
		
		if(type == 1) { //if it is a registered user generate a return receipt email for a Ru - no 15% deduction 
			
			message = "Receipt for: " + username + "\n";
			message += "100% movie credit refund issued \n";
			message += "Ticket ID: " + ticketId + " seat ID: " + seatId + " Showtime ID: " + showtimeId + "Payment ID: " + paymentId + "\n";
			message += "Date Purchased: "  + timePurchased.getMonth() +"/" + timePurchased.getDate() + "/" + (timePurchased.getYear()+1900) + "\n";
			message += "Date Refunded: " + currentDate.getMonth() +"/" + currentDate.getDate() + "/"+ (currentDate.getYear() +1900);
			
		} else { //user is not RU so no discount 
			message = "Receipt for: " + username + "\n"; 
			message += "85% movie credit refund issued \n"; //100% minus 15% fee
			message += "Ticket ID: " + ticketId + " seat ID: " + seatId + " Showtime ID: " + showtimeId + "Payment ID: " + paymentId + "\n";
			message += "Date Purchased: "  + timePurchased.getMonth() +"/" + timePurchased.getDate() + "/" + (timePurchased.getYear()+1900) + "\n";
			message += "Date Refunded: " + currentDate.getMonth() +"/" + currentDate.getDate() + "/"+ (currentDate.getYear() +1900);
			
		}
		
		
		//set up email 
		Email email = ec.addEmail(0, message);
		
		ec.addEmailToUser(username, email.getEmailId()); //add the email to the user 
	
		tc.cancelTicket(ticketId); //call the ticket controller to cancel the ticket. Should also free up the occupied seat.
		
	}
	
	
	
}
