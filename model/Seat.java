package model;

public class Seat {

	int seatId;
	int row;
	int col;
	String screen;
	boolean isTaken;
	int type; // 0 = OU, 1 = RU
	
	public Seat() {
		
	}
	
	public Seat(int seatId, int row, int col, String screen, boolean isTaken, int type) {
		this.seatId = seatId;
		this.row = row;
		this.col = col;
		this.screen = screen;
		this.isTaken = isTaken;
		this.type = type;
	}
	
	//getters and setters
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isTaken() {
		return isTaken;
	}
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	
	/*
	//additional functions 
	void claimSeat() {
		isTaken = true;
	}
	
	void freeSeat() {
		isTaken = false;
	}
	*/
	
}
