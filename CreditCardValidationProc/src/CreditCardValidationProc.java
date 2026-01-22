
public class CreditCardValidationProc
{
	private long cardNum;
	
	public CreditCardValidationProc() 
	{
		super();
		this.cardNum = 4539704354706391L;
	}
	
    public static boolean isValid(long number)
    {	

        return false;
    }

    public static int getDigit(int number)
    {
    		int digit = 0;
    		while(number > 0)
    		{
    			digit += number % 10;
    			number /= 10;
    		}

        return digit;
    }
    
    // Remove Casts?
    public static int sumOfEven(long number)
    {   
		boolean even = true; // Assuming number is always 16 digits
		int sumOfEven = 0;

		while(number > 0)
		{
			if(even)
			{
				long lastDigit = number % 10;				
				sumOfEven += getDigit((int) lastDigit);;
				even = false;
			}
			else
			{
				even = true;
			}
			
			number /= 10;
		}
		
        return sumOfEven;
    }
    
    public static int sumOfOdd(long number)
    {
    	
        return getDigit((int) number);
    }

    public static boolean prefixMatched(long number, int d)
    {
        return false;
    }

    public static int getSize(long d)
    {
        return 0;
    }

    public static long getPrefix(long number, int d)
    {
        return 0;
    }
    
    public static void main(String[] args)
    {

    }

}

