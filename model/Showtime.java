package model;

import java.util.ArrayList;


public class Showtime {

	private Time localDateTime;
	private Theatre theatre;
	private Movie movie;
	private ArrayList<Seat> seats;
	private boolean isFull;
	
	
	
	public Showtime(Time localDateTime, Theatre theatre, Movie movie, ArrayList<Seat> seats, boolean isFull) {
		this.localDateTime = localDateTime;
		this.theatre = theatre;
		this.movie = movie;
		setSeats(seats);
		this.isFull = isFull;
	}
	public ArrayList<Seat> getAvailableSeats() {
		ArrayList<Seat> open;
	
		for(int i=0; i< MAXSEATS; i++) {
			if (this.getSeats().get(i).isTaken ==false) {
				open.add(this.getSeats().get(i));

			}
			
		}
	}
	public Time getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(Time localDateTime) {
		this.localDateTime = localDateTime;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
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
