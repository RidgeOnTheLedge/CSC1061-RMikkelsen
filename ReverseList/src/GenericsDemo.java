
public class GenericsDemo
{

	public static void main(String[] args)
	{
		ReverseList<Integer> list1 = new ReverseList<>();
		
		list1.add(1);
		list1.add(2);
		System.out.println(list1.getList());
		for (int i = 0; i < list1.size(); i++)
		{
			System.out.print(list1.get(i) + " ");
		}
		
		ReverseList<Apple> list2 = new ReverseList<>();
	}

}
