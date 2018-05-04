package ar.com.intive.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.com.intive.main.Rental;
import ar.com.intive.main.RentalDay;
import ar.com.intive.main.RentalFamily;
import ar.com.intive.main.RentalHour;
import ar.com.intive.main.RentalPrices;
import ar.com.intive.main.RentalWeek;

public class RentalTest {
	
	int numberOfRentalHours;
	int numberOfRentalDays;
	int numberOfRentalWeeks;
	double delta = 0.1;
	
	float expected_by_hour;
	float expected_per_day;
	float expected_by_week;
	
	float total_family_rental;
	
	float expected_value_for_family_rental;

	@Before
	public void before(){
		
		numberOfRentalHours = 2;
		numberOfRentalDays = 2;
		numberOfRentalWeeks = 2;
		
		expected_by_hour = RentalPrices.PRICE_RENTAL_HOUR * 2;
		expected_per_day = RentalPrices.PRICE_RENTAL_DAY * 2;
		expected_by_week = RentalPrices.PRICE_RENTAL_WEEK * 2;
		
		total_family_rental = expected_by_hour + expected_per_day + expected_by_week;
		
		expected_value_for_family_rental = total_family_rental
				- ((total_family_rental * RentalPrices.DISCOUNT_RATE_RENTAL_FAMILY) / 100);

	}
	
	@Test
	public void shouldReturnPricePerDayExpected() {
		// when ... then ... should

		float resultado = new RentalDay(numberOfRentalDays).getTotalPrice();
		assertEquals(expected_per_day, resultado, delta);
	}

	@Test
	public void shouldReturnPricePerHourExpected() {

		float resultado = new RentalHour(numberOfRentalHours).getTotalPrice();

		assertEquals(expected_by_hour, resultado, delta);

	}

	@Test
	public void shouldReturnPricePerWeekExpected() {

		float resultado = new RentalWeek(numberOfRentalWeeks).getTotalPrice();

		assertEquals(expected_by_week, resultado, delta);

	}

	@Test
	public void shouldReturnPriceOfFamilyRentalExpected() {

		List<Rental> familyRental = new ArrayList<Rental>();

		familyRental.add(new RentalDay(numberOfRentalDays));
		familyRental.add(new RentalHour(numberOfRentalHours));
		familyRental.add(new RentalWeek(numberOfRentalWeeks));

		RentalFamily rentalFamily = new RentalFamily();
		rentalFamily.setRentals(familyRental);

		float resultado = rentalFamily.getTotalPrice();

		assertEquals(expected_value_for_family_rental, resultado, delta);

	}

	@Test
	public void shouldReturnExceptionExpected() {

		try {
			RentalFamily rentalFamily = new RentalFamily();
			rentalFamily.setRentals(null);
			fail("fail test");
		} catch (IllegalArgumentException ex) {
		} catch (Exception ex) {
			fail("Another exception");
		}
	}

}
