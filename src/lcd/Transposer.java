package lcd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Transposer {

	public Iterable<Iterable<String>> transpose(
			Iterable<Iterable<String>> input) {
		List<Iterable<String>> result = new ArrayList<Iterable<String>>();
		int numberOfInputRows = countNumberOfInputRows(input);
		for (int i = 0; i < numberOfInputRows; i++) {
			Iterable<String> newIthRow = allIthValuesFromInputRows(input, i);
			result.add(newIthRow);
		}
		return result;
	}

	private int countNumberOfInputRows(Iterable<Iterable<String>> input) {
		return toList(input.iterator().next()).size();
	}

	private Iterable<String> allIthValuesFromInputRows(
			Iterable<Iterable<String>> input, 
			int i) {
		List<String> outputRow = new ArrayList<String>();
		Iterator<Iterable<String>> inputRows = input.iterator();
		while (inputRows.hasNext()) {
			outputRow.add(get(inputRows.next(),i));
		}
		return outputRow;
	}

	private String get(Iterable<String> next, int which) {
		Iterator<String> iter = next.iterator();
		for (int i = 0; i < which; i++) {
			iter.next();
		}
		return iter.next();
	}

	private List<String> toList(Iterable<String> next) {
		List<String> values = new ArrayList<String>();
		Iterator<String> iterator = next.iterator();
		while (iterator.hasNext()) {
			values.add(iterator.next());
		}
		return values;
	}

}
