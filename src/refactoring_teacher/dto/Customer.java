package refactoring_teacher.dto;

import java.util.ArrayList;
import java.util.List;

import refactoring_teacher.statement.HtmlStatement;
import refactoring_teacher.statement.Statement;
import refactoring_teacher.statement.TextStatement;

public class Customer {
	private String name;
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addRental(Rental aRental) {
		this.rentals.add(aRental);
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public String statement() {
		Statement stmt = new TextStatement();
		return stmt.value(this);
	}

	public String htmlStatement() {
		Statement stmt = new HtmlStatement();
		return stmt.value(this);
	}
	
	public int getTotalFrequentRenterPoints() {
		int result = 0;
		for(Rental each : rentals){
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

	public double getTotalCharge() {
		double result = 0.0;
		for(Rental each : rentals){
			result += each.getCharge();
		}
		return result;
	}

}
