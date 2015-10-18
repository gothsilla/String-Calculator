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
		assertEquals(10, Calculator.add("10"));
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
    
    @Test(expected = RuntimeException.class)  
    public void testThrowExecptionForOneNegNumber() {
    	try{
    		Calculator.add("-1,2");
    	}
    	catch (RuntimeException ex){
    		
    		assertEquals("Negatives not allowed: -1",ex.getMessage());
    		throw ex;
    	}
    }
	
    @Test(expected = RuntimeException.class)  
    public void testThrowExecptionForMultNegNumbers() {
    	try{
    		Calculator.add("2,-4,3,-5");
    	}
    	catch (RuntimeException ex){
    		
    		assertEquals("Negatives not allowed: -4,-5",ex.getMessage());
    		throw ex;
    	}
    }

    @Test(expected = RuntimeException.class)  
    public void testThrowExecptionForNegNumWithDiffDelim() {
    	try{
    		Calculator.add("//;\n-1;2");
    	}
    	catch (RuntimeException ex){
    		
    		assertEquals("Negatives not allowed: -1",ex.getMessage());
    		throw ex;
    	}
    }

    @Test
    public void testMoreThanAllowed() {

    	assertEquals(2, Calculator.add("1001,2"));
    } 

    @Test
    public void testMultipleMoreThanAllowed() {

    	assertEquals(702, Calculator.add("1001,2,700,2000"));
    } 

	@Test
    public void testDelOfAnyLength() {

    	assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    } 

    @Test
    public void testMultDelimeters() {

    	assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testMultDelimetersOfAnyLength() {

    	assertEquals(6, Calculator.add("//[***][%%%]\n1***2%%%3"));
    }

    @Test
    public void testMultDelimetersOfAnyLength2() {

    	assertEquals(21, Calculator.add("//[***][%%%][##]\n1***2%%%3**5###10"));
    }

}



