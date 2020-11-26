package main.controller;

import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
// import main.model.User;
// import main.model.RegisteredUser;

public class UserController {
	
	DBController DB;
	
	public UserController() {
		DB = new DBController();
	}
	
	boolean isValidUser(String username){
		// if username exists in User table return true
		// else return false
		ResultSet result = DB.query("SELECT COUNT(*) AS count FROM User WHERE User.username = ?", username);
		try {
			result.next();
			int userCount = result.getInt("count");
			if(userCount == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	void addRegisteredUser(String username, String name, String address, int cardNum){
		// check if username is already in user table ???
		// if so, change type to 1 (RU)
		// if not, add username and 1 to User
		// add username and other info to RegUser
		if(isValidUser(username)) { // this username already exists, let's update it to RU
			DB.execute("UPDATE user SET userType = 1 WHERE username = ?", username);
		} else {
			DB.execute("INSERT INTO user (username, userType) VALUES (?, ?)", username, 1); // type = 1 --> RU
		}
		DB.execute("INSERT INTO reguser (username, name, address, cardNum) VALUES (?, ?, ?, ?)", username, name, address, cardNum);
	}
	
	
	void addGuestUser(String username) {
		if(!isValidUser(username)) { // if this username already exists, don't do anything
			DB.execute("INSERT INTO user (username, userType) VALUES (?, ?)", username, 0); // type = 0 --> OU
		}
	}
	
	/* test once RegisteredUser class is available
	ArrayList<RegisteredUser> getRegisteredUsers(){
		// get all rows from RegUser table
		// construct into RegisteredUser objects and add to arraylist
		ResultSet r = DB.query("SELECT * FROM RegUser");
		ArrayList<RegisteredUser> ruList = new ArrayList<RegisteredUser>();
		try {
			while(result.next()) {
				RegisteredUser ru = new RegisteredUser(r.getString("username"), r.getString("name"), r.getString("address"), r.getInt("cardNum"));
				ruList.add(ru);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ruList;
	}
	*/
	
	public static void main(String[] args) {
		// a few tests...
		UserController uc = new UserController();
		uc.addGuestUser("alexa123");
		uc.addRegisteredUser("alexa123", "alexa", "123 main st", 10001234);
		uc.addRegisteredUser("jordan11", "jordan", "1 home st", 99999999);
		System.out.println(uc.isValidUser("alexa123"));
	}
	
}
