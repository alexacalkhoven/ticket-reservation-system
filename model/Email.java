package model;

public class Email {

	String message;
	int emailId; 
	int type; //0 = receipt, 1 = promo
	
	public Email() {
		
	}
	
	public Email(String message) {
		this.message = message;
	}

	//getters and setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getEmailId() {
		return emailId;
	}

	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
