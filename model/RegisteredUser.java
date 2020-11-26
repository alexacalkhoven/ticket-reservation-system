package model;

public class RegisteredUser extends User{

	String name;
	String address;
	Email email;
	int cardNum;//card num - 8digits 
	
	public RegisteredUser(String name, String address, int cardNum) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.cardNum = cardNum;
		
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


	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	
	
	
}
