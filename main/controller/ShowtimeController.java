package main.controller;

public class ShowtimeController {

	private DBController DB;

	public ShowtimeController() {
		DB = new DBController();
	}

	/*
	public ArrayList<Showtime> getShowtimes() {
		ResultSet r = DB.query("SELECT * FROM Showtime");
		ArrayList<Showtime> showtimeList = new ArrayList<Showtime>();
		try {
			while (r.next()) {
				Showtime showtime = new Showtime(r.getInt("showtimeId"), r.getString("time"), r.getInt("movieId"));
				showtimeList.add(showtime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return showtimeList;
	}
	*/
	
	// get showtime(showtimeId)?

}
