package ar.com.intive.main;

public class RentalHour implements Rental {

	private int rented_hours = 0;

	public RentalHour(int rented_hours) {
		this.rented_hours = rented_hours;
	}

	public float getTotalPrice() {
		return RentalPrices.PRICE_RENTAL_HOUR * this.rented_hours;
	}

	public int getRented_hours() {
		return rented_hours;
	}

	public void setRented_hours(int rented_hours) {
		this.rented_hours = rented_hours;
	}

}
