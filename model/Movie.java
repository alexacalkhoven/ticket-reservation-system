package model;

public class Movie {

	private String name;
	private Promotion promotion;
	
	public Movie(String name, Promotion promotion) {
		this.name = name;
		this.promotion = promotion;
	}

	public Movie(String name) {
		this.name = name;
		addPromotion(new Promotion());
	}
	
	public Movie() {
		setName("");
		addPromotion(new Promotion());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	//adds promotion to provided movie
	public void addPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
}
