package lcd;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

public class TransposerTest extends TestCase {

	@SuppressWarnings("serial")
	public void testTransposeOn2by2Returns2by2() {
		Transposer transposer = new Transposer();
		final Iterable<String> numbers = new ArrayList<String>() {
			{
				add("one");
				add("two");
			}
		};
		final Iterable<String> colors = new ArrayList<String>() {
			{
				add("red");
				add("blue");
			}
		};
		Iterable<Iterable<String>> input = new ArrayList<Iterable<String>>() {
			{
				add(numbers);
				add(colors);
			}
		};
		Iterable<Iterable<String>> result = transposer.transpose(input);
		assertEquals(2, size(result));
		Iterator<Iterable<String>> innerIterables = result.iterator();
		Iterable<String> firstResult = innerIterables.next();
		Iterator<String> firstResultIterator = firstResult.iterator();
		assertEquals("one", firstResultIterator.next());
		assertEquals("red", firstResultIterator.next());
		Iterable<String> secondResult = innerIterables.next();
		Iterator<String> secondResultIterator = secondResult.iterator();
		assertEquals("two", secondResultIterator.next());
		assertEquals("blue", secondResultIterator.next());
	}

	@SuppressWarnings("serial")
	public void testTransposeOn1by2Returns2by1() {
		Transposer transposer = new Transposer();
		final Iterable<String> numbers = new ArrayList<String>() {
			{
				add("one");
			}
		};
		final Iterable<String> colors = new ArrayList<String>() {
			{
				add("red");
			}
		};
		Iterable<Iterable<String>> input = new ArrayList<Iterable<String>>() {
			{
				add(numbers);
				add(colors);
			}
		};
		Iterable<Iterable<String>> result = transposer.transpose(input);
		assertEquals(1, size(result));
		Iterator<Iterable<String>> innerIterables = result.iterator();
		Iterable<String> firstResult = innerIterables.next();
		assertEquals(2, size(firstResult));
		Iterator<String> firstResultIterator = firstResult.iterator();
		assertEquals("one", firstResultIterator.next());
		assertEquals("red", firstResultIterator.next());
	}

	private int size(Iterable<?> result) {
		int i = 0;
		Iterator<?> iter = result.iterator();
		while (iter.hasNext()) {
			i++;
			iter.next();
		}
		return i;
	}
}
