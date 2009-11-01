package lcd;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class LCD {
	private static final String RIGHT = "  |";
	private static final String LEFT = "|  ";
	private static final String BOTH = "| |";
	private static final String BLANK = "   ";
	private static final String MIDDLE = " - ";
	private static final String newline = "\n";
	
	private static final Map<Integer, String[]> DIGITS = new HashMap<Integer, String[]>() {
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

		private String[] digit(String top, String midTop, String middle,
				String midBottom, String bottom) {
			return new String[] { top, midTop, middle, midBottom, bottom};
		}
	};

	public String display(final int i) {
		return join(digitsAsListOfStringArrays(i));
	}

	private List<String[]> digitsAsListOfStringArrays(int i) {
		List<String[]> strings = new ArrayList<String[]>();
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
		return ! "".equals(s);
	}

	private String join(List<String[]> digits) {
		StringBuffer display = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			for (String[] aDigit : digits) {
				display.append(aDigit[i]);
				display.append(' ');
			}
			chomp(display);
			display.append(newline);
		}
		return chomp(display).toString();
	}

	private StringBuffer chomp(StringBuffer string) {
		string.deleteCharAt(string.length()-1);
		return string;
	}
}
