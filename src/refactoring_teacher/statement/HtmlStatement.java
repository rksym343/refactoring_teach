package refactoring_teacher.statement;

import refactoring_teacher.dto.Customer;
import refactoring_teacher.dto.Rental;

public class HtmlStatement extends Statement {
	
	@Override	
	protected String footerString(Customer customer) {
		return String.format("<p>누적 대여료 : <em>%s</em>%n<p>적립 포인트 : <em>%s</em>%n", customer.getTotalCharge(),
				customer.getTotalFrequentRenterPoints());
	}
	
	@Override
	protected String eachRentalString(Rental each) {
		return String.format("nbsp;nbsp;%s nbsp;nbsp; %s<br>%n", each.getMovie().getTitle(), each.getCharge());
	}
	
	@Override
	protected String headerString(String cutomerName) {
		return "<h1><em>" + cutomerName + "고객님의 대여기록</em></h1><p>\n";
	}
}
