package harrypotter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookPriceCalculator {
	CombinationProducer combinationProducer;
	
	public BigDecimal calculate(List<Book> books) {
		Set<Set<Set<Book>>> allCombinations = combinationProducer.createCombinations(books);
		Set<Set<Book>> bestDiscountSet = pickBestDiscount(allCombinations);
		return computeCost(bestDiscountSet);
	}

	private BigDecimal computeCost(Set<Set<Book>> bestDiscountSet) {
		for (Set<Book> setOfBooks : bestDiscountSet) {
			
		}
		return null;
	}

	private Set<Set<Book>> pickBestDiscount(Set<Set<Set<Book>>> allCombinations) {
		// TODO Auto-generated method stub
		return null;
	}

	private BigDecimal applyDiscount(List<Book> books, BigDecimal total) {
		int discount = 0;
		switch (distinctBookCount(books)) {
		case 1:
			discount = 0;
			break;
		case 2:
			discount = 5;
			break;
		case 3:
			discount = 10;
			break;
		}
		BigDecimal discountPct = new BigDecimal(100 - discount)
				.divide(new BigDecimal(100));
		return total.multiply(discountPct)
				.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private int distinctBookCount(List<Book> books) {
		Set<BookType> bookTypes = new HashSet<BookType>();
		for (Book b : books) {
			bookTypes.add(b.bookType());
		}
		return bookTypes.size();
	}

}
