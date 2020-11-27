package main.model;

public class Payment {

	boolean isComplete;
	PaymentController paymentController;
	int paymentId;
	double amount;
	int cardNum;
	
	public Payment() {
		
	}
	
	public Payment(boolean isComplete, PaymentController paymentController, int paymentId, double amount, int cardNum) {
		this.isComplete = isComplete;
		this.paymentController = paymentController;
		this.paymentId = paymentId;
		this.amount = amount;
		this.cardNum = cardNum;
	}
	
	//getters and setters
	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public PaymentController getPaymentController() {
		return paymentController;
	}

	public void setPaymentController(PaymentController paymentController) {
		this.paymentController = paymentController;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	//additoinal functions 
	void makePaymentToTheatre(User user) { //need to change payment functionality now that account is no longer going to be considered . 
		
		
	}
	
	void makeRefundToUser(User user) { //need to change payment functionality now that account is no longer going to be considered . 
		
	}
	
	
	
}
