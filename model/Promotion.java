package model;
import java.util.ArrayList;

public class Promotion extends Email{

	String desc;
	ArrayList<Showtime> applicableShowtimes;
	
	public Promotion() {
		
	}
	
	public Promotion(String desc, ArrayList<Showtime> applicableShowtimes) {
		this.desc = desc;
		this.applicableShowtimes = applicableShowtimes;
	}

	//getters and setters
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ArrayList<Showtime> getApplicableShowtimes() {
		return applicableShowtimes;
	}

	public void setApplicableShowtimes(ArrayList<Showtime> applicableShowtimes) {
		this.applicableShowtimes = applicableShowtimes;
	}
	
	
	
	
	
	
}
