package edu.frcc.csc1060j.SpellChecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SpellChecker
{
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			return;
		}
		
		//File name is listOfWords.txt
		MyTreeSet<String> ts = loadFile(args[0]);

		System.out.println("Tree Height: " + ts.getTreeHeight());
		Scanner scnr = new Scanner(System.in);
		
		List<String> allWords = new ArrayList<>();
		System.out.println("Type Text (When done hit enter and type END): ");

		while (true)
		{
			String userInput = scnr.nextLine();
			String[] words = userInput.replaceAll("[^a-zA-Z' ]", "").split("\\s+");

			if (userInput.equals("END"))
			{
				break;
			}
			
			for (String w : words)
			{
				allWords.add(w);
			}
			
			for (String w : allWords)
			{
				if (!ts.contains(w))
				{
					System.out.println(w + " is spelt wrong.");
				}
			}
			allWords.clear();
		}
		scnr.close();
	}

	public static MyTreeSet<String> loadFile(String fileName)
	{
		MyTreeSet<String> treeSet = new MyTreeSet<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				if (line.trim().isEmpty())
				{
					continue;
				}

				String tokens = line;

				// Print the text in the file
				// System.out.println(tokens);
				treeSet.add(tokens);
			}
			System.out.println("File Loaded");
			return treeSet;
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
