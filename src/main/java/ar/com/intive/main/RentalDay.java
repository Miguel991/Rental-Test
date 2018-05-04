package ar.com.intive.main;

public class RentalDay implements Rental {

	private int rented_days = 0;

	public RentalDay(int rented_days) {
		this.rented_days = rented_days;
	}

	public float getTotalPrice() {
		return RentalPrices.PRICE_RENTAL_DAY * this.rented_days;
	}

	public int getRented_days() {
		return rented_days;
	}

	public void setRented_days(int rented_days) {
		this.rented_days = rented_days;
	}

}
