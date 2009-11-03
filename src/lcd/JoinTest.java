package lcd;

import java.util.Arrays;

import junit.framework.TestCase;

public class JoinTest extends TestCase {
	public void testJoinAandBwithSpaceYieldsAspaceB() {
		Functor<Iterable<String>, String> joinWithSpace = new Join(' ');
		Iterable<String> asList = Arrays.asList("A", "B");
		assertEquals("A B", joinWithSpace.invoke(asList));
	}
}
