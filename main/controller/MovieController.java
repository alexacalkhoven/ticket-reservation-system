package main.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.model.Movie;

public class MovieController {

	private DBController DB;

	public MovieController() {
		DB = DBController.getInstance();
	}

	// returns all movies in the database. will be useful for search movies.
	public ArrayList<Movie> getMovies() {
		ResultSet r = DB.query("SELECT * FROM Movie");
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		try {
			while (r.next()) {
				Movie movie = new Movie(r.getInt("movieId"), r.getString("name"));
				movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieList;
	}

	public Movie addMovie(String name) {
		int movieId = DB.executeReturnKey("INSERT INTO Movie (name) VALUES (?)", name);
		if (movieId == -1)
			return null;
		return new Movie(movieId, name);
	}

	// gets Movie for movieId
	public Movie getMovie(int movieId) {
		ResultSet r = DB.query("SELECT * FROM Movie WHERE movieId = ?", movieId);
		try {
			if (r.next()) {
				return new Movie(r.getInt("movieId"), r.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public static void main(String[] args) { // a few tests... MovieController mc
	 * = new MovieController(); mc.addMovie("the incredibles");
	 * mc.addMovie("mean girls"); ArrayList<Movie> ml = mc.getMovies(); for(int i =
	 * 0; i < ml.size(); i++) { System.out.println(ml.get(i).getName()); } }
	 */
}
