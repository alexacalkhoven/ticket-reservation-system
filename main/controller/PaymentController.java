package main.controller;

import java.sql.ResultSet;

public class PaymentController {

	private DBController DB;

	public PaymentController() {
		DB = new DBController();
	}
	
	//addPayment(cardNum, amount): Payment ???
	//getPayment(paymentId): Payment
	
	/*
	 * Payment
		paymentId amount cardNum
		Amount is a double between 0 and 100

	 */
	/*
	// Adds a payment to the DB, returns the new payment object
	public Payment addPayment(double amount, int cardNum) {
		int paymentId = DB.executeReturnKey("INSERT INTO Payment (amount, cardNum) VALUES (?, ?)", amount, cardNum); 
		if(paymentId == -1) return null;
		return new Payment(paymentId, amount, cardNum);
	}
	*/
	
	/*
	// gets payment for paymentId
	public Payment getPayment(int paymentId) {
		ResultSet r = DB.query("SELECT * FROM Payment WHERE paymentId = ?", paymentId);
		if(r.next()) {
			return Payment(r.getInt("paymentId"), r.getDouble("amount"), r.getInt("cardNum"));
		}
		return null;
	}
	*/
}
