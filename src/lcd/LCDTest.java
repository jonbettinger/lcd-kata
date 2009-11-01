package lcd;

import junit.framework.TestCase;

public class LCDTest extends TestCase {
	private final char newline = '\n';
	private LCD lcd;
	
	public void setUp() {
		lcd = new LCD();
	}

	private final String one = new StringBuffer()
	.append("   ").append(newline)
	.append("  |").append(newline)
	.append("   ").append(newline)
	.append("  |").append(newline)
	.append("   ").toString();

	private final String two = new StringBuffer()
	.append(" - ").append(newline)
	.append("  |").append(newline)
	.append(" - ").append(newline)
	.append("|  ").append(newline)
	.append(" - ").toString();

	private final String three = new StringBuffer()
	.append(" - ").append(newline)
	.append("  |").append(newline)
	.append(" - ").append(newline)
	.append("  |").append(newline)
	.append(" - ").toString();

	private final String four = new StringBuffer()
	.append("   ").append(newline)
	.append("| |").append(newline)
	.append(" - ").append(newline)
	.append("  |").append(newline)
	.append("   ").toString();

	private final String five = new StringBuffer()
	.append(" - ").append(newline)
	.append("|  ").append(newline)
	.append(" - ").append(newline)
	.append("  |").append(newline)
	.append(" - ").toString();

	private final String six = new StringBuffer()
	.append("   ").append(newline)
	.append("|  ").append(newline)
	.append(" - ").append(newline)
	.append("| |").append(newline)
	.append(" - ").toString();

	private final String seven = new StringBuffer()
	.append(" - ").append(newline)
	.append("  |").append(newline)
	.append("   ").append(newline)
	.append("  |").append(newline)
	.append("   ").toString();

	private final String eight = new StringBuffer()
	.append(" - ").append(newline)
	.append("| |").append(newline)
	.append(" - ").append(newline)
	.append("| |").append(newline)
	.append(" - ").toString();

	private final String nine = new StringBuffer()
	.append(" - ").append(newline)
	.append("| |").append(newline)
	.append(" - ").append(newline)
	.append("  |").append(newline)
	.append("   ").toString();

	private final String zero = new StringBuffer()
	.append(" - ").append(newline)
	.append("| |").append(newline)
	.append("   ").append(newline)
	.append("| |").append(newline)
	.append(" - ").toString();

	private final String twentyThree = new StringBuffer()
	.append(" -   - ").append(newline)
	.append("  |   |").append(newline)
	.append(" -   - ").append(newline)
	.append("|     |").append(newline)
	.append(" -   - ").toString();

	private final String cccxlv = new StringBuffer()
	.append(" -       - ").append(newline)
	.append("  | | | |  ").append(newline)
	.append(" -   -   - ").append(newline)
	.append("  |   |   |").append(newline)
	.append(" -       - ").toString();

	public void test1() {
		assertEquals(one, lcd.display(1));
	}

	public void test2() {
		assertEquals(two, lcd.display(2));
	}

	public void test3() {
		assertEquals(three, lcd.display(3));
	}

	public void test4() {
		assertEquals(four, lcd.display(4));
	}

	public void test5() {
		assertEquals(five, lcd.display(5));
	}
	
	public void test6() {
		assertEquals(six, lcd.display(6));
	}

	public void test7() {
		assertEquals(seven, lcd.display(7));
	}

	public void test8() {
		assertEquals(eight, lcd.display(8));
	}

	public void test9() {
		assertEquals(nine, lcd.display(9));
	}

	public void test0() {
		assertEquals(zero, lcd.display(0));
	}
	public void test23() {
		assertEquals(twentyThree, lcd.display(23));
	}
	public void test345() {
		assertEquals(cccxlv, lcd.display(345));
	}
}
