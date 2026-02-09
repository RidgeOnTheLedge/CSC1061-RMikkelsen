import java.util.LinkedList;
import java.util.List;

public class TestFI
{

	public static void main(String[] args)
	{
		FinancialInstitution fi1 = new CreditUnion("Peoples Bank");
		FinancialInstitution fi2 = new Bank("Peoples Bank");
		FinancialInstitution fi3 = new NonLender("Peoples Bank");

		System.out.println("My Bank interset rate: " + 
				fi1.getInterestRate() * 100 + "%"); 
		
		List<FinancialInstitution> fiList = new LinkedList();
		fiList.add(fi3);
		fiList.add(new CreditUnion("My CI"));
		fiList.add(new NonLender("Usless FI"));
		
		fiList.get(0).setFiID(123555323);
		fiList.get(1).setFiID(157545323);
		fiList.get(2).setFiID(790240323);	
	}

}
