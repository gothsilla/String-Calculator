package is.ru.stringcalculator;

public class Calculator {

	public static int add (String text) {
		
		if(text.equals(""))
			return 0;

		else if (text.contains("-"))
		{
			return negative(text);
		}

		else if(text.contains(",") || text.contains("\n") || text.startsWith("//"))
		{
			return sum(splitNumbers(text));
		}

		else
			return 1;
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) {
	
		String delim = "";
		String number = "";
		
		if (numbers.startsWith("//"))
		{
			if (numbers.charAt(2) != '[')
			{
				delim = numbers.substring(2,3);
				number = numbers.substring(4);
				
				return number.split(delim);
			}
			
			else if (numbers.contains("]["))
			{					
				String firstDel = "";
				int n = numbers.indexOf("\n");
				String rest = numbers.substring(n+1);
				String input = numbers.substring(3, n-1);
								
				for (int i = 0; i < input.length(); i++)
				{
					if (input.charAt(i) != ']' && input.charAt(i) != '[')
					{
						firstDel += input.substring(i, i+1);
					}
					
				}
				
				firstDel = "[" + firstDel + "]";
				return rest.split(firstDel);
			}
			
			else 
			{
				int i = 0;
				delim = splitNum(numbers);
				for (i = 0; i < numbers.length(); i++)
				{
					if (numbers.substring(i, i+1).equals("\n"))
					{
						break;
					}
				}
				number = numbers.substring(i+1);
				number = number.replace(delim, ",");
			}
		    return number.split("[,\n]");
		}
		return numbers.split("[,\n]");
	}
	
	public static String splitNum(String numbers)
	{
		String delim = "";
				
		String num = numbers.substring(3);
				
		if (numbers.charAt(2) == '[')
		{
			for (int i = 0; i < num.length(); i++)
			{
				if (num.charAt(i) != ']')
				{
					delim += num.substring(i, i+1);
				}
				else
				{
					break;
				}
			}
		}		
		return delim;
	}
	
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){

        	if (!number.isEmpty())
        	{
        		int tempNum = toInt(number);
	    	
	    		if (tempNum <= 1000)
	    		{
			   		total += tempNum;
	    		}
        	}
		}
		return total;
    }

    private static int negative(String number) {
		
		String message = "Negatives not allowed: ";
		
		String totalNum = "";
		String num = "";
		
		for (int i = 0; i < number.length(); i++)
		{
			if (number.substring(i, i+1).contains("-"))
			{

				num += number.substring(i, i+2);

				totalNum = message + num;
				
				num += ",";
			}
		}
		throw new IllegalArgumentException(totalNum);
	}
}



