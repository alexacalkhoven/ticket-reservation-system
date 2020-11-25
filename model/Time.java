package model;

public class Time {

	private String day;
	private String month;
	private String year;
	private String hour;
	
	
	public Time(String day, String month, String year, String hour, String minute) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
	}

	public Time() {
		setDay("");
		setMonth("");
		setYear("");
		setHour("");
		setMinute("");
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}
	private String minute;
	
	public String getTime() {
		return day+"/"+month+"/"+year+"  "+hour+"/"+minute;
	}
	
	
	public String getDay() {
		return day+"/"+month+"/"+year;
		
	}
	public String getHour() {
		return hour+"/"+minute;
	}
}
