package main.model;
import java.util.ArrayList;

public class Promotion extends Email{

	String desc;
	ArrayList<ShowTime> applicableShowtimes;
	
	public Promotion() {
		
	}
	
	public Promotion(String desc, ArrayList<ShowTime> applicableShowtimes) {
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

	public ArrayList<ShowTime> getApplicableShowtimes() {
		return applicableShowtimes;
	}

	public void setApplicableShowtimes(ArrayList<ShowTime> applicableShowtimes) {
		this.applicableShowtimes = applicableShowtimes;
	}
	
	
	
	
	
	
}
