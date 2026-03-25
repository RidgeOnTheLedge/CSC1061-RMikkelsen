
public class Fibonacci
{
	public static long recursionCnt = 0;
	public static long[] termArray = new long[200];

	public static void main(String[] args)
	{
		int n = 50;

		System.out.println("The " + n + "th term is " + fibIterator(n));
		System.out.println(recursionCnt);
	}
	
	private static long fibIterator(long n)
	{
		long ans = 1;
		if(n <= 1)
		{
			return n;
		}
		for(int i = 0; i < n; i++)
		{
			long temp = ans;
			ans = temp + ans;
		}
		return ans;
	}
	
	private static long fibRecursive(int n)
	{
		if (n <= 1)
		{
			return n;
		}
		
		return fibRecursive(n - 1) + fibRecursive(n - 2);
	}
	
	public static long fibDynamic(int n)
	{
		if(n <= 1)
		{
			return n;
		}
		
		if (termArray[n] > 0)
		{
			return termArray[n];
		}
		
		recursionCnt++;

		long ans = fibDynamic(n - 1) + fibDynamic(n - 2);
		termArray[n] = ans;
		return ans;
	}
}


