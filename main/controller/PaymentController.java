package main.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import main.model.Payment;


public class PaymentController {

	private DBController DB;

	public PaymentController() {
		DB = DBController.getInstance();
	}
	
	// Adds a payment to the DB, returns the new payment object
	public Payment addPayment(double amount, int cardNum) {
		int paymentId = DB.executeReturnKey("INSERT INTO Payment (amount, cardNum) VALUES (?, ?)", amount, cardNum); 
		if(paymentId == -1) return null;
		return new Payment(paymentId, amount, cardNum);
	}
	
	// gets payment for paymentId
	public Payment getPayment(int paymentId) {
		ResultSet r = DB.query("SELECT * FROM Payment WHERE paymentId = ?", paymentId);
		try {
			if(r.next()) {
				return new Payment(r.getInt("paymentId"), r.getDouble("amount"), r.getInt("cardNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	public static void main(String[] args) {
		// a few tests...
		PaymentController pc = new PaymentController();
		Payment p = pc.addPayment(99.12, 12345678);
		pc.getPayment(p.getPaymentId());
	}	
	*/
}
