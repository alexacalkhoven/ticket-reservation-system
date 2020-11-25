package model;

public class OrdinaryUser {

	public void registerAsRegisteredUser(String name, String address, Card card, String email) {
		RegisteredUser ru;
		ru.setRegisteredUser(name,address,card,email);
	}
}
