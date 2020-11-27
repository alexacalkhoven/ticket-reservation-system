package main.model;

public class OrdinaryUser {

	private String username;

	public OrdinaryUser(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void registerAsRegisteredUser(String name, String address, Card card, Email email) {
		RegisteredUser ru=new RegisteredUser(name,address,card,email);

	}
}
