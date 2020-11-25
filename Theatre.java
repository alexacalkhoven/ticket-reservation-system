package model;

import java.util.ArrayList;

public class Theatre {
	private String name;
	private ArrayList<Showtime> showtimes;
	//private Account account;
	
	
	public String getName() {
		return name;
	}

	public Theatre(String name, ArrayList<Showtime> showtimes) {
		this.name = name;
		this.showtimes = showtimes;
	}
	
	

	public Theatre() {
		setName("");
		setShowtimes(new ArrayList<Showtime>());
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Showtime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(ArrayList<Showtime> showtimes) {
		this.showtimes = showtimes;
	}

	

	public void addShowtime(Showtime show) {
		this.showtimes.add(show);
	}
}
