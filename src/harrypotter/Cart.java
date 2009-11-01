package harrypotter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	public List<Book> books = new ArrayList<Book>();
	BookPriceCalculator calculator;

	public Cart(BookPriceCalculator calculator) {
		this.calculator = calculator;
		
	}
	public BigDecimal total() {
		return calculator.calculate(books);
	}


	public void add(Book book) {
		books.add(book);
	}

}
