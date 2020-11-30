package main.model;

import java.util.Date;

/**
 * Holds information on all the available showtimes for specific movies.
 * This class is used to pass information between GUI and controllers.
 * @author Alexa Calkhoven
 * @author Madisson Carle
 * @author Trevor Brown
 * @author Noah Bradley
 * 
 *
 */
public class Showtime {

	private Date timeOfShow; 
	private int showtimeId;
	private int movieId;

	/**
	 * Constructs showtime
	 * @param showtimeId Id of showtime
	 * @param time time of showtime
	 * @param movieId movie at showtime
	 */
	public Showtime(int showtimeId, Date time, int movieId) {
		this.showtimeId = showtimeId;
		this.timeOfShow = time;
		this.movieId = movieId;
	}

	/**
	 * constructor
	 */
	public Showtime() {
			
	}

	/**
	 * Converts showtime to string for GUI
	 * @return Returns the string result
	 */
	@Override
	public String toString() {
		return "time:" + timeOfShow.toString() + " showtimeId: " + showtimeId + " movieId: " + movieId;
	}

	/**
	 * Gets time for showtime
	 * @return Returns time as a string
	 */
	public Date getTimeOfShow() {
		return timeOfShow;
	}

	/**
	 * Sets time for showtime
	 * @param time Time to be set
	 */
	public void setTime(Date time) {
		this.timeOfShow = time;
	}

	/**
	 * Gets the showtime Id
	 * @return Returns the int showtime ID
	 */
	public int getShowtimeId() {
		return showtimeId;
	}

	/**
	 * Sets the showtime ID
	 * @param showtimeId The ID to be set
	 */
	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	/**
	 * Gets the movie ID for the showtime
	 * @return Returns the int Movie ID
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * Sets the movie ID for the showtime
	 * @param movieId The movie ID to be set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

}

