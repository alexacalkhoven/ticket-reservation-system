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

	public void registerAsRegisteredUser(String username, String name, String address, int card, String email) {
		RegisteredUser ru=new RegisteredUser(username, name,address,card,email);

	}
}
