package main.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieController {

	private DBController DB;

	public MovieController() {
		DB = new DBController();
	}
	
	//getMovies(): Movie []
	/*
	 * Movie
		movieId name
	 */
	
	/*
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
	*/
	
	//addMovie()?
}
