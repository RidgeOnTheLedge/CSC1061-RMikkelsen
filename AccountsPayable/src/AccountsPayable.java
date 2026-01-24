import java.util.Scanner;

public class AccountsPayable
{
	private static Scanner scanner;
	
	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);
		
		Employee[] payableEmployees = new Employee[6];

		getEmployees(payableEmployees);
		
		for(Employee emp : payableEmployees)
		{
			System.out.println(emp.getFirstName() + " " + emp.getLastName());
			System.out.println("Payment Amount: " + emp.getPaymentAmount());
			//printEmp(emp); another way to print employees (includes SSN)
		}
		
		for(Employee emp : payableEmployees)
		{
			if(emp instanceof BasePlusCommissionEmployee bpce)
			{
				double currentBase = bpce.getBasePay();
				bpce.setBasePay(currentBase + currentBase * 0.1);
			}
		}
		
		for(Employee emp : payableEmployees)
		{
			System.out.println(emp.getFirstName() + " " + emp.getLastName());
			System.out.println("Payment Amount: " + emp.getPaymentAmount());
			//printEmp(emp); another way to print employees (includes SSN)
		}
		
		scanner.close();
	}

	private static void getEmployees(Employee[] payableEmployees)
	{
		Employee emp = null;

		for (int i = 0; i < payableEmployees.length; i++)
		{	
			System.out.println("Enter Employee Type (1-4)" + "\n1) Salaried Employee" + "\n2) Commission Employee"
					+ "\n3) Base Plus Commission Employee" + "\n4) Hourly Employee");
			int userNum = scanner.nextInt();

			System.out.println("First Name: ");
			scanner.nextLine();
			String firstName = scanner.nextLine();

			System.out.println("Last Name: ");
			String lastName = scanner.nextLine();

			System.out.println("Social Security Number: ");
			long socialSecurityNumber = scanner.nextLong();
			scanner.nextLine();

			if (userNum == 1)
			{
				System.out.println("Enter Weekly Salary: ");
				double weeklySalary = scanner.nextDouble();
				emp = new SalariedEmployee(firstName, lastName, socialSecurityNumber, weeklySalary);
			} 
			else if (userNum == 2 || userNum == 3)
			{
				System.out.println("Enter Gross Sales: ");
				double grossSales = scanner.nextDouble();
				System.out.println("Enter Commission Rate: ");
				double commissionRate = scanner.nextDouble();

				// handle BasePlusCommissionEmployee
				if (userNum == 3)
				{
					System.out.println("Enter Base Pay: ");
					double basePay = scanner.nextDouble();
					emp = new BasePlusCommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales,
							commissionRate, basePay);
				} 
				else
				{
					emp = new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
				}
			}
			else if (userNum == 4)
			{
				System.out.println("Enter Hours: ");
				int hours = scanner.nextInt();
				System.out.println("Enter Hourly Wage: ");
				double hourlyWage = scanner.nextDouble();

				emp = new HourlyEmployee(firstName, lastName, socialSecurityNumber, hourlyWage, hours);
			}
			else
			{
				// probably add a loop later, instead of crashing program
				 throw new IllegalArgumentException("Invalid Employee Number"); 
			}
			payableEmployees[i] = emp;
		}
	}

	private static void printEmpToString(Employee emp)
	{
		System.out.println(emp);
	}

	// Print out the employee object without toString
	private static void printEmp(Employee emp)
	{
		System.out.println("First Name: " + emp.getFirstName());
		System.out.println("Last Name: " + emp.getLastName());
		System.out.println("Social Security Number: " + emp.getSocialSecurityNumber());
		System.out.println("Payment Amount: " + emp.getPaymentAmount());
	}

	private static void printAllEmployees(Employee[] payableEmployees)
	{
		for (Employee e : payableEmployees)
		{
			System.out.println(e);
		}
	}
}
