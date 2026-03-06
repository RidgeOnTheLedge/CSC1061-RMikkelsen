package edu.frcc.csc1061j.BookTree;

public class Book
{
	public static void main(String[] args)
	{
		BookTree myBook = new BookTree("Trees for Dummies");

		myBook.addBookNode("Chp 5", 5, 0, 0);
		myBook.addBookNode("Chp 4", 4, 0, 0);
		myBook.addBookNode("Chp 3", 3, 0, 0);
		myBook.addBookNode("Chp 2", 2, 0, 0);
		myBook.addBookNode("Chp 1", 1, 0, 0);

		// add sections first
		myBook.addBookNode("Sec 5.5", 5, 5, 0);
		myBook.addBookNode("Sec 2.3", 2, 3, 0);
		myBook.addBookNode("Sec 4.2", 4, 2, 0);
		myBook.addBookNode("Sec 1.2", 1, 2, 0);
		myBook.addBookNode("Sec 3.4", 3, 4, 0);

		// now add subsections
		myBook.addBookNode("Sec 5.5.1", 5, 5, 1);
		myBook.addBookNode("Sec 2.3.1", 2, 3, 1);
		myBook.addBookNode("Sec 4.2.3", 4, 2, 3);
		myBook.addBookNode("Sec 1.2.4", 1, 2, 4);
		myBook.addBookNode("Sec 3.4.5", 3, 4, 5);
		
		for(BookNode node : myBook)
		{
			System.out.println(node);
		}
	}
}
