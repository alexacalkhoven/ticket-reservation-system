package model;

import java.util.ArrayList;



public class Showtime {

	public int MAXSEATS=100;
	private Time localDateTime;
	private Theater theater;
	private Movie movie;
	private ArrayList<Seat> seats;
	private boolean isFull;
	
	
	//constructor
	public Showtime(Time localDateTime, Theater theater, Movie movie, ArrayList<Seat> seats, boolean isFull) {
		this.localDateTime = localDateTime;
		this.theater = theater;
		this.movie = movie;
		setSeats(seats);
		this.isFull = isFull;
	}
	
	//finds all seats that are not taken and puts them into an arrayList which is returned
	public ArrayList<Seat> getAvailableSeats() {
		ArrayList<Seat> open = new ArrayList<Seat>();
	
		for(int i=0; i< MAXSEATS; i++) {
			if (this.getSeats().get(i).isTaken ==false) {
				open.add(this.getSeats().get(i));

			}
			
		}
		return open;
	}
	public Time getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(Time localDateTime) {
		this.localDateTime = localDateTime;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theatre) {
		this.theater = theatre;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	
}
