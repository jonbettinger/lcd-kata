package lcd;

public class Join implements Functor<Iterable<String>, String> {
	final char c;

	public Join(final char c) {
		this.c = c;
	}

	public String invoke(Iterable<String> input) {
		return join(input, c);
	}

	private String join(Iterable<String> line, char c) {
		StringBuilder buffer = new StringBuilder();
		for (Object l : line) {
			buffer.append(l);
			buffer.append(c);
		}
		return chomp(buffer).toString();
	}

	private StringBuilder chomp(StringBuilder string) {
		string.deleteCharAt(string.length() - 1);
		return string;
	}

}
