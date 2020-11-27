package model;





public class Showtime {

	//public int MAXSEATS=20;
	private Time time;
	private int showtimeId;
	private int movieId;

	
	
	
	
	//finds all seats that are not taken and puts them into an arrayList which is returned
//	public ArrayList<Seat> getAvailableSeats() {
//		ArrayList<Seat> open = new ArrayList<Seat>();
//	
//		for(int i=0; i< MAXSEATS; i++) {
//			if (this.getSeats().get(i).isTaken ==false) {
//				open.add(this.getSeats().get(i));
//
//			}
//			
//		}
//		return open;
//	}
	public Showtime(Time time, int showtimeId, int movieId) {
	this.time = time;
	this.showtimeId = showtimeId;
	this.movieId = movieId;
}
	public Showtime() {
		
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
