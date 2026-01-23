
public class CreditCardValidationProc
{
	private CreditCardValidationProc(){}
	
   	private static boolean isValid(long number)
    {	
    		if(getSize(number) >= 13 && getSize(number) <= 16)
    		{

    			int sumEvenOdd = sumOfDoubledEven(number) + sumOfOdd(number);
	    		if(sumEvenOdd % 10 == 0)
	    		{
	    			return true;
	    		}
    		}
        return false;
    }

    private static int getDigit(int number)
    {
    		// Is there a faster way to check if its a single digit?
    		int digit = 0;
    		while(number > 0)
    		{
    			digit += number % 10;
    			number /= 10;
    		}

        return digit;
    }
    
    // Remove Casts?
    private static int sumOfDoubledEven(long number)
    {   
		int position = 1;
		int sumOfEven = 0;

		while(number > 0)
		{
			if(position % 2 == 0)
			{
				int lastDigit = (int)(number % 10);	
				sumOfEven += getDigit(lastDigit * 2);
			}
				
			number /= 10;
			position++;
		}
		
        return sumOfEven;
    }
    
    private static int sumOfOdd(long number)
    {
    		int position = 1;
    		int sumOfOdd = 0;
   
    		while(number > 0)
    		{
    			if(position % 2 != 0)
    			{
    				int lastDigit = (int) (number % 10);				
    				sumOfOdd += getDigit(lastDigit);
    			}
    			    			
    			number /= 10;
    			position++;
    		}
    		
    		return sumOfOdd;
    }

    public static boolean prefixMatched(long number, int d)
    {
    		int size = getSize(number);
    		long k = getPrefix(number, d);
    		for(int i = 0; i < size - getSize(k) ; i++)
    		{
    			number /= 10;
    		}

    		if(number == d)
    		{
    			return true;
    		}
        return false;
    }

    public static long getPrefix(long number, int k)
    {
    		int numberSize = getSize(number);
    		int kSize = getSize(k);
    		

    		if(numberSize <= kSize)
    		{
    			return number;
    		}
    			
    		while(numberSize > kSize)
    		{
    			number /= 10;
    			numberSize = getSize(number);
    		}
    		
        return number;
    }
    
    public static int getSize(long d)
    {
    		int size = 0;
    		while(d > 0)
    		{
    			size++;
    			d /= 10;		
    		}
    		
        return size;
    }


    public static void main(String[] args)
    {
    		System.out.println(isValid(3600675582921455L));
    		System.out.println(prefixMatched(3600675582921455L, 3600));	
    }

}

