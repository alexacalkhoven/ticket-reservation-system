package model;

public class OrdinaryUser {

public void registerAsRegisteredUser(String name, String address, Card card, Email email) {
		RegisteredUser ru=new RegisteredUser(name,address,card,email);
		
	}
}
