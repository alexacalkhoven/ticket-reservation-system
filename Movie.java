package model;

public class Movie {

	private String name;
	private Promotion promotion;
	
	public Movie(String name, Promotion promotion) {
		this.name = name;
		this.promotion = promotion;
	}

	public Movie() {
		setName("");
		setPromotion(new Promotion());
	}
	public void addPromotion(Promotion promo) {
		this.promotion=promo;
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

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
}
