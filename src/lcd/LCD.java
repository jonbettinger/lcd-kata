package lcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class LCD {
	Transposer transposer = new Transposer();

	private Functor<Iterable<String>, String> joinWithSpace = new Join(' ');
	private Functor<Iterable<String>, String> joinWithNewline = new Join('\n');
	private static final String RIGHT = "  |";
	private static final String LEFT = "|  ";
	private static final String BOTH = "| |";
	private static final String BLANK = "   ";
	private static final String MIDDLE = " - ";

	private static final Map<Integer, List<String>> DIGITS = new HashMap<Integer, List<String>>() {
		{
			put(1, digit(BLANK, RIGHT, BLANK, RIGHT, BLANK));
			put(2, digit(MIDDLE, RIGHT, MIDDLE, LEFT, MIDDLE));
			put(3, digit(MIDDLE, RIGHT, MIDDLE, RIGHT, MIDDLE));
			put(4, digit(BLANK, BOTH, MIDDLE, RIGHT, BLANK));
			put(5, digit(MIDDLE, LEFT, MIDDLE, RIGHT, MIDDLE));
			put(6, digit(BLANK, LEFT, MIDDLE, BOTH, MIDDLE));
			put(7, digit(MIDDLE, RIGHT, BLANK, RIGHT, BLANK));
			put(8, digit(MIDDLE, BOTH, MIDDLE, BOTH, MIDDLE));
			put(9, digit(MIDDLE, BOTH, MIDDLE, RIGHT, BLANK));
			put(0, digit(MIDDLE, BOTH, BLANK, BOTH, MIDDLE));
		}

		private List<String> digit(String top, String midTop, String middle,
				String midBottom, String bottom) {
			return Arrays.asList(top, midTop, middle, midBottom, bottom);
		}
	};

	public String display(final int theInt) {
		Iterable<Iterable<String>> digitsAsListOfStringArrays = digitsAsListOfStringArrays(theInt);
		Iterable<Iterable<String>> transposedDigits = transposer
				.transpose(digitsAsListOfStringArrays);
		Iterable<String> lines = map(transposedDigits, joinWithSpace);
		return joinWithNewline.invoke(lines);
	}

	private Iterable<Iterable<String>> digitsAsListOfStringArrays(int i) {
		List<Iterable<String>> strings = new ArrayList<Iterable<String>>();
		String[] split = (i + "").split("");
		for (String s : split) {
			if (notEmpty(s)) {
				Integer anInt = Integer.valueOf(s);
				strings.add(DIGITS.get(anInt));
			}
		}
		return strings;
	}

	private boolean notEmpty(String s) {
		return !"".equals(s);
	}

	private <I, O> Iterable<O> map(Iterable<I> iterable, Functor<I, O> functor) {
		List<O> result = new ArrayList<O>();
		for (I i : iterable) {
			result.add(functor.invoke(i));
		}
		return result;
	}
}