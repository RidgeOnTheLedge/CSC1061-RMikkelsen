import java.util.ArrayList;

public class Phone implements Cloneable
{
	private static int nextIMEX;
	private ArrayList<Integer> IMEI = new ArrayList<Integer>(15);
	private String name;
	private String processor;
	private String cache;
	private String storage;
	public Phone(String name, String processor, String cache, String storage)
	{
		super();
		this.name = name;
		this.processor = processor;
		this.cache = cache;
		this.storage = storage;
	}
	
	public Phone()
	{
		
	}
	
	private void setIMEI()
	{
		
		for(int i = 0; i < 15; i++)
		{		
			if(IMEI.get(i) != 0)
			{
				
			}
			else if(IMEI.get(i) == 9)
			{
				IMEI.set(i, 0); // Shorter way to write?
				
			}
			
		}
		System.out.println(IMEI.toString());
	}
	
	public static void main(String args[])
	{
		Phone phone = new Phone();
		phone.setIMEI();
	}
	
	
	
}
