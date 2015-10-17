package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testManyNumbers() {
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLine() {
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimiter() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    (expected = IllegalArgumentException.class)
    public void testNegativeNum() {
    	assertEquals("Negatives not allowed: -1", Calculator.add("-1,2"));
    }

    @Test
    (expected = IllegalArgumentException.class)
    public void testManyNegativeNum() {
    	assertEquals("Negatives not allowed: -4,-5", Calculator.add("2,-4,3,-5"));
    }

    @Test
    (expected = IllegalArgumentException.class)
    public void testManyNegativeNumWithDiffDelim() {
    	assertEquals("Negatives not allowed: -1", Calculator.add("//;\n-1;2"));
    }
}



