package harrypotter;

import java.math.BigDecimal;

public class Book {
	private BigDecimal cost;
	private final BookType bookType;
	
	public Book(BookType bookType, BigDecimal cost) {
		this.bookType = bookType;
		this.cost = cost;
	}

	public BigDecimal cost() {
		return cost;
	}

	public BookType bookType() {
		return bookType;
	}

}
