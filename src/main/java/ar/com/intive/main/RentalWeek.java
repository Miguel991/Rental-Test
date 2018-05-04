package ar.com.intive.main;

public class RentalWeek implements Rental {

	private int number_of_weeks_rental = 0;

	public RentalWeek(int number_of_weeks_rental) {
		this.number_of_weeks_rental = number_of_weeks_rental;
	}

	public float getTotalPrice() {
		return RentalPrices.PRICE_RENTAL_WEEK * this.number_of_weeks_rental;
	}

	public int getNumber_of_weeks_rental() {
		return number_of_weeks_rental;
	}

	public void setNumber_of_weeks_rental(int number_of_weeks_rental) {
		this.number_of_weeks_rental = number_of_weeks_rental;
	}

}
