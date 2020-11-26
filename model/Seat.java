package model;

public class Seat {

	String number;
	boolean isTaken;
	char screen;
	int type; // 0 = OU, 1 = RU
	
	public Seat() {
		
	}
	
	public Seat(int type, String number, boolean isTaken, char screen) {
		this.type = type;
		this.number = number;
		this.isTaken = isTaken;
		this.screen = screen;
	}
	
	//getters and setters
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSeatNumber() {
		return number;
	}
	public void setSeatNumber(String number) {
		this.number = number;
	}
	public boolean isTaken() {
		return isTaken;
	}
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	
	public char getScreen() {
		return screen;
	}
	public void setScreen(char screen) {
		this.screen = screen;
	}
	
	
	//additional functions 
	void claimSeat() {
		isTaken = true;
	}
	
	void freeSeat() {
		isTaken = false;
	}
	
}
