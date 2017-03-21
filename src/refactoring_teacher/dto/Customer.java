package refactoring_teacher.dto;

import java.util.ArrayList;
import java.util.List;

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

	public String statement() {
		// 대여료와 적립포인트 출력
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + "고객님의 대여기록\n");
		for(Rental each : rentals){
			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getCharge()));
		}//for loop
		sb.append(String.format("누적 대여료 : %s%n적립 포인트 : %s%n", getTotalCharge(), getTotalFrequentRenterPoints()));
		return sb.toString();
	}

	public String htmlStatement() {
		// 대여료와 적립포인트 출력
		StringBuilder sb = new StringBuilder();
		sb.append("<h1><em>"+ getName() + "고객님의 대여기록</em></h1><p>\n");
		for(Rental each : rentals){
			sb.append(String.format("nbsp;nbsp;%s nbsp;nbsp; %s<br>%n", each.getMovie().getTitle(), each.getCharge()));
		}//for loop
		sb.append(String.format("<p>누적 대여료 : <em>%s</em>%n<p>적립 포인트 : <em>%s</em>%n", getTotalCharge(), getTotalFrequentRenterPoints()));
		return sb.toString();
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for(Rental each : rentals){
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

	private double getTotalCharge() {
		double result = 0.0;
		for(Rental each : rentals){
			result += each.getCharge();
		}
		return result;
	}

}
