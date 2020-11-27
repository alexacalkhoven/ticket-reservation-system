package model;

import java.util.ArrayList;

public class Theater {
	private String name;
	private ArrayList<Showtime> showtimes;
	//private Account account;
	
	
	public String getName() {
		return name;
	}

	public Theater(String name, ArrayList<Showtime> showtimes) {
		this.name = name;
		this.showtimes = showtimes;
	}
	
	

	public Theater(String name) {
		setName(name);
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

	
	//adds new promotion to arrayList of promotions for theater 
	public void addShowtime(Showtime show) {
		this.showtimes.add(show);
	}
}
