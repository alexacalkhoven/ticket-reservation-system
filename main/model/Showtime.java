package model;

public class Showtime {

	private String time; // keep this as a string for now since we only really have to print it out.
	private int showtimeId;
	private int movieId;

	public Showtime(int showtimeId, String time, int movieId) {
		this.showtimeId = showtimeId;
		this.time = time;
		this.movieId = movieId;
	}

	public Showtime() {

	}

	@Override
	public String toString() {
		return "time:" + time + " showtimeId: " + showtimeId + " movieId: " + movieId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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
