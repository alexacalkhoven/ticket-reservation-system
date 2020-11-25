package model;

public class Payment {

	boolean isComplete;
	PaymentController paymentController;
	
	public Payment() {
		
	}
	
	public Payment(boolean isComplete, PaymentController paymentController) {
		this.isComplete = isComplete;
		this.paymentController = paymentController;	
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

	//additoinal functions 
	void makePaymentToTheatre(User user) { //need to change payment functionality now that account is no longer going to be considered . 
		
		
	}
	
	void makeRefundToUser(User user) { //need to change payment functionality now that account is no longer going to be considered . 
		
	}
	
	
	
}
