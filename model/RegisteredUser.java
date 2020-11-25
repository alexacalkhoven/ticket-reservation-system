package model;

public class RegisteredUser extends User{

	String name;
	String address;
	Card card; 
	Email email;
	
	public RegisteredUser(String name, String address, Card card, Email email) {
		this.name = name;
		this.address = address;
		this.card = card; 
		this.email = email;
		
	}
	
	//getters and setters
	public RegisteredUser() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
	
	
	
	//additional functions 
	void addPaymentMethod(Card card) {
		this.card = card;
	}
	
	void payFee(double value) {
		
		card.makePayment(value);
		
	}
	
	
}
