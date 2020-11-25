package model;

import java.util.ArrayList;

public class Ticket {

	private String name;
	private Showtime showtime;
	private Receipt receipt;
	private Seat seat;
	public Payment payment;

	public Ticket(String name, Showtime showtime, Receipt receipt, Payment payment) {
		this.name = name;
		this.showtime = showtime;
		this.receipt = receipt;
		this.payment = payment;
	}

	public Ticket() {
		setName("");
		setShowtime(new Showtime());
		setReceipt(new Receipt());
		setPayment(new Payment());
	}

	//cancel ticket at theatre by freeing the seat corresponding to the ticket and getting a refund receipt
	public void cancelTicket(Theater theater) {
		ArrayList<Showtime> st=theater.getShowtimes();
		//find showtime of ticket in db
		for(int i=0; i<st.size();i++) {
			if(st.get(i)==this.showtime) {
				ArrayList<Seat> s =st.get(i).getSeats();
				//find corresponding seat 
				for(int j=0; j< s.size(); j++) {
					//change seat state
					if(s.get(j)==seat) {
						s.get(j).freeSeat();
					}
					//change showtime state
					theater.setShowtimes(st);
					receipt.createRefundReceipt(); //get refund for ticket
				}
			}


		}


	}

	//book a ticket for a specific showtime 
	public void payForTicket(Theater theater) {
		ArrayList<Showtime> st=theater.getShowtimes();
		//find showtime of ticket in db
		for(int i=0; i<st.size();i++) {
			if(st.get(i)==this.showtime) {
				ArrayList<Seat> s =st.get(i).getSeats();
				//find corresponding seat 
				for(int j=0; j< s.size(); j++) {
					//change seat state
					if(s.get(j)==seat) {
						s.get(j).claimSeat();
					}
					//change showtime state
					theater.setShowtimes(st);
					payment.makePaymentToTheatre();//make payment for ticket
					if(payment.isComplete==true) //check to see payment went through
						receipt.emailReceiptAndTicket(); //get recepit for payment with ticket
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Showtime getShowtime() {
		return showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}


}
