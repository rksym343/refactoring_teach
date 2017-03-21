package refactoring_teacher.statement;

import refactoring_teacher.dto.Customer;
import refactoring_teacher.dto.Rental;

public class TextStatement extends Statement {
	
	@Override
	protected String footerString(Customer customer) {
		return String.format("누적 대여료 : %s%n적립 포인트 : %s%n", customer.getTotalCharge(), customer.getTotalFrequentRenterPoints());
	}

	@Override
	protected String eachRentalString(Rental each) {
		return String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getCharge());
	}

	@Override
	protected String headerString(String cutomerName) {
		return cutomerName + "고객님의 대여기록\n";
	}
}
