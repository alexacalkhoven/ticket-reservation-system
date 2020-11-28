package main.model;

public class RegisteredUser extends User{

	String name;
	String address;
	int cardNum;//card num - 8digits 
	//String email; // do we need this?
	boolean feePaid;
	
	public RegisteredUser(String username, String name, String address, int cardNum, boolean feePaid) {
		super(1, username);
		this.name = name;
		this.address = address;
		this.cardNum = cardNum;
		this.feePaid=feePaid;
		
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
	
	public boolean checkFeePaid() {
		return feePaid;
	}
	
	public void setFeePaid(boolean fee) {
		this.feePaid=fee;
	}
	
}
