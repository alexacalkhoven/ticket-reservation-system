package main.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.model.Email;

public class EmailController {
	
	private DBController DB;

	public EmailController() {
		DB = DBController.getInstance();
	}
	
	/**
	 * Fetches all emails attached to a username. Will be needed to load the email view GUI.
	 * 
	 * @param username User to fetch emails for
	 * @return ArrayList of emails
	 */
	public ArrayList<Email> getEmails(String username) {
		ResultSet r = DB.query("SELECT emailId FROM UserToEmail WHERE username = ?", username);
		ArrayList<Email> emailList = new ArrayList<Email>();
		try {
			while(r.next()) {
				int emailId = r.getInt("emailId");
				ResultSet e = DB.query("SELECT * FROM Email WHERE emailId = ?", emailId);
				e.next();
				Email email = new Email(e.getInt("emailId"), e.getInt("emailType"), e.getString("message"));
				emailList.add(email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailList;
	}
	
	// creates receipt email for ticket PURCHASE. inserts to Email and UserToEmail.
	public boolean addEmail(String username, String message) {
		// insert to Email
		int emailId = DB.executeReturnKey("INSERT INTO Email (emailType, message) VALUES (?, ?)", 0, message); 
		if(emailId == -1) return false;
		// insert to UserToEmail
		int rowCount = DB.execute("INSERT INTO UserToEmail (username, emailId) VALUES (?, ?)", username, emailId);
		if(rowCount != 0) return false;
		return true; 
	}
	
	
	/*
	public static void main(String[] args) {
		// a few tests...
		EmailController ec = new EmailController();
		ec.addEmail("alexa12", "hello???");
		ec.addEmail("alexa12", "email2");
		ArrayList<Email> el = ec.getEmails("alexa12");
		for(int i = 0; i < el.size(); i++) {
			System.out.println(el.get(i).getEmailId() + " " + el.get(i).getMessage());
		}
	}	
	*/
}
