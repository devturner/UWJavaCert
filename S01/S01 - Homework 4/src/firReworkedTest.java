import static org.junit.Assert.*;

import org.junit.Test;


public class firReworkedTest {

	@Test
	public void Smalltest() {
		String result = fibReworked.fibonacci(15);
		assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377", result);
	}

	@Test
	public void zero() {
		String result = fibReworked.fibonacci(0);
		assertEquals("0, 1", result);
	}

	@Test
	public void Large() {
		String result = fibReworked.fibonacci(30);
		assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229", result );
	}
}
