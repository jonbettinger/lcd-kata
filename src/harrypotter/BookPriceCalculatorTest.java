package harrypotter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static harrypotter.BookType.*;
import junit.framework.TestCase;

public class BookPriceCalculatorTest extends TestCase {
	BookPriceCalculator calculator = new BookPriceCalculator();
	
	public void testTwoOfTypeAAndOneOfTypeBGives5PercentDiscountOnTwoBooks() {
		List<Book> books = new ArrayList<Book>() {{
			add(new Book(A, decimal(8)));
			add(new Book(A, decimal(8)));
			add(new Book(B, decimal(8)));
		}};
		BigDecimal expected = new BigDecimal(2*8*.95 + 8).setScale(2, BigDecimal.ROUND_HALF_UP);
		assertEquals(expected, calculator.calculate(books));
	}
	private BigDecimal decimal(int i) {
			return new BigDecimal(8).setScale(2);
	};
}
