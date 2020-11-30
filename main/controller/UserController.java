package main.controller;

import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import main.model.Email;
import main.model.RegisteredUser;

/**
 * Controls access to the User table in the database.
 * 
 * @author Alexa Calkhoven
 *
 */
public class UserController {

	private DBController DB;

	public UserController() {
		DB = DBController.getInstance();
	}

	/**
	 * Checks to see if username is present in the User table.
	 * 
	 * @param username PK of user.
	 * @return if user is valid or not. True if valid, false if not.
	 */
	public boolean isValidUser(String username) {
		// if username exists in User table return true
		// else return false
		ResultSet result = DB.query("SELECT COUNT(*) AS count FROM User WHERE User.username = ?", username);
		try {
			result.next();
			int userCount = result.getInt("count");
			if (userCount == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Returns false if failed to enter. This may be due to duplicate PK, or another
	 * SQL related error. Checks if username entered corresponds to an existing user
	 * already, if so, changes their type to registered.
	 * 
	 * NOTE: we may want this to return a User/RegUser object in the future
	 * depending on what operations we will need in the GUI.
	 * 
	 * @param username PK for user.
	 * @param name     name of user.
	 * @param address  address of user (String format).
	 * @param cardNum  card number to have on file for user.
	 * @return
	 */
	public boolean addRegisteredUser(String username, String name, String address, int cardNum, boolean feePaid) {
		// check if username is already in user table ???
		// if so, change type to 1 (RU)
		// if not, add username and 1 to User
		// add username and other info to RegUser

		// TODO
		// ADD LOGIC TO ADD TYPE 1 EMAILS TO NEW RU's EMAIL LIST HERE
		
		int userTable;
		if (isValidUser(username)) { // this username already exists, let's update it to RU
			userTable = DB.execute("UPDATE User SET userType = 1 WHERE username = ?", username);
		} else {
			userTable = DB.execute("INSERT INTO User (username, userType) VALUES (?, ?)", username, 1); // type = 1 -->
																										// RU
		}

		int regTable = DB.execute(
				"INSERT INTO RegUser (username, name, address, cardNum, feePaid) VALUES (?, ?, ?, ?, ?)", username,
				name, address, cardNum, feePaid);

		if (userTable != 1 || regTable != 1)
			return false;
		
		// add promo emails to account
		/*
		EmailController ec = new EmailController();
		ArrayList<Email> emailList = ec.getPromoEmails();
		System.out.println("Emails being added...");
		for(int i = 0; i < emailList.size(); i++) {
			ec.addEmailToUser(username, emailList.get(i).getEmailId());
		}
		*/
		return true;
	}

	/**
	 * Adds username and type = 0 (OU) to User table for guest logins.
	 * 
	 * @param username PK of user.
	 */
	public void addGuestUser(String username) {
		if (!isValidUser(username)) { // if this username already exists, don't do anything
			DB.execute("INSERT INTO User (username, userType) VALUES (?, ?)", username, 0); // type = 0 --> OU
		}
	}

	/**
	 * Gets all RUs in database. Will be helpful for sending promotions.
	 * 
	 * @return ArrayList of RUs
	 */
	public ArrayList<RegisteredUser> getRegisteredUsers() {
		// get all rows from RegUser table
		// construct into RegisteredUser objects and add to arraylist
		ResultSet r = DB.query("SELECT * FROM RegUser");
		ArrayList<RegisteredUser> ruList = new ArrayList<RegisteredUser>();
		try {
			while (r.next()) {
				RegisteredUser ru = new RegisteredUser(r.getString("username"), r.getString("name"),
						r.getString("address"), r.getInt("cardNum"), false);
				ruList.add(ru);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ruList;
	}
	
	public boolean isRegisteredUser(String username) {
		// if username exists in RegUser table return true
		// else return false
		ResultSet result = DB.query("SELECT COUNT(*) AS count FROM RegUser WHERE username = ?", username);
		try {
			result.next();
			int userCount = result.getInt("count");
			if (userCount == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
