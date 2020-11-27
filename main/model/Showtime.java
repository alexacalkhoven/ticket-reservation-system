package main.model;





public class Showtime {

	//public int MAXSEATS=20;
	private Time time;
	private int showtimeId;
	private int movieId;





	public Showtime(Time time, int showtimeId, int movieId) {
		this.time = time;
		this.showtimeId = showtimeId;
		this.movieId = movieId;
	}
	public Showtime() {

	}
	
	@Override
	public String toString() {
		return "time:" + time + "showtimeId: " + showtimeId + "movieId: " + movieId;
	}
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}



}
