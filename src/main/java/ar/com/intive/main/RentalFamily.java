package ar.com.intive.main;

import java.util.List;

public class RentalFamily implements Rental {

	private List<Rental> rentals;
	
	public RentalFamily(){}

	public float getTotalPrice() {

		float totalToPay = 0;

		for (Rental rental : this.getRentals()) {

			totalToPay += rental.getTotalPrice();

		}

		return getDiscount(totalToPay);
	}

	private float getDiscount(float total) {
		return total - ((total * RentalPrices.DISCOUNT_RATE_RENTAL_FAMILY) / 100);
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		if (rentals == null) {
			throw new IllegalArgumentException("the argument must not be null");
		} else {
			this.rentals = rentals;
		}
	}

}
