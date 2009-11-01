package harrypotter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class BookCombinationProducerTest extends TestCase {
	public void testOneBookReturnsOneSet() {
		CombinationProducer producer = new CombinationProducer();
		List<Book> books = new ArrayList<Book>() {{
			add(new Book(BookType.A, new BigDecimal(8)));
		}};
		assertEquals(1, producer.createCombinations(books).size());
	}
}
