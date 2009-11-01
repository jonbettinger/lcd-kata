package harrypotter;

import java.math.BigDecimal;

import junit.framework.TestCase;

public class CartTest extends TestCase {
	
	Cart cart; 
	
	public void setUp() {
		cart = new Cart(new BookPriceCalculator());
	}


	public void testAddingOneBookToCartAddsNoDiscount() {
		Book book = new Book(BookType.A, decimal(8));
		cart.add(book);
		assertEquals(book.cost(), cart.total());
	}

	public void testAddingTwoDifferentBooksGives5PercentDiscount() {
		Book book1 = new Book(BookType.A, decimal(8));
		Book book2 = new Book(BookType.B, decimal(8));
		cart.add(book1);
		cart.add(book2);
		BigDecimal expectedCost = book1.cost().add(book2.cost()).multiply(
				new BigDecimal(.95)).setScale(2, BigDecimal.ROUND_HALF_UP);
		assertEquals(expectedCost, cart.total());
	}

	public void testAddingTwoBooksOfSameTypeGives0PercentDiscount() {
		Book book1 = new Book(BookType.A, decimal(8));
		Book book2 = new Book(BookType.A, decimal(8));
		cart.add(book1);
		cart.add(book2);
		BigDecimal expectedCost = book1.cost().add(book2.cost()).setScale(2, BigDecimal.ROUND_HALF_UP);
		assertEquals(expectedCost, cart.total());
	}
	
	public void testAddingThreeDifferentBooksGives10PercentDiscount() {
		Book book1 = new Book(BookType.A, decimal(8));
		Book book2 = new Book(BookType.B, decimal(8));
		Book book3 = new Book(BookType.C, decimal(8));
		cart.add(book1);
		cart.add(book2);
		cart.add(book3);
		
		BigDecimal expectedCost = book1.cost().add(book2.cost()).add(book3.cost()).multiply(
				new BigDecimal(.90)).setScale(2, BigDecimal.ROUND_HALF_UP);
		assertEquals(expectedCost, cart.total());
	}
	private BigDecimal decimal(int i) {
		return new BigDecimal(i).setScale(2);
	}
}
