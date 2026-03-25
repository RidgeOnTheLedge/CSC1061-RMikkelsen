package edu.frcc.csc1061j.SentimentAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SentimentAnalyzer
{

	public static void main(String[] args)
	{
		MyHashMap<String, Integer> map = loadFile("sentiments.txt");
		Scanner scnr = new Scanner(System.in);
		int i = 0;
		List<String> allWords = new ArrayList<>();
		System.out.println("Enter Text: ");
		while (true)
		{
			String userInput = scnr.nextLine();
			String[] words = userInput.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

			if (userInput.equalsIgnoreCase("end"))
			{
				break;
			}
			for (String w : words)
			{
				allWords.add(w);
			}
		}
		int sentiment = 0;
		String oldWord = null;
		for (String w : allWords)
		{
			if ((oldWord != null) && (map.get(oldWord + " " + w)) != null)
			{
				sentiment += map.get(oldWord + " " + w);
				System.out.println(oldWord + " " + w + " " + map.get(oldWord + " " + w));
			} else if (map.get(w) != null)
			{
				sentiment += map.get(w);
				System.out.println(w + " " + map.get(w));
			}

			oldWord = w;
		}

		double average = allWords.isEmpty() ? 0 : (double) sentiment / allWords.size();

		System.out.println("Word count: " + allWords.size());
		System.out.println("Total sentiment: " + sentiment);
		System.out.printf("Average sentiment: %.2f\n", average);
	}

	public static MyHashMap<String, Integer> loadFile(String fileName)
	{
		MyHashMap<String, Integer> map = new MyHashMap<String, Integer>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				if (line.trim().isEmpty())
				{
					continue;
				}

				String[] tokens = line.split(",", 2);
				if (tokens.length < 2)
				{
					continue;
				}
				// Print the text in the file
				// System.out.println(tokens[0] + " " + Integer.parseInt(tokens[1]));
				map.put(tokens[0], Integer.parseInt(tokens[1]));

			}
			System.out.println("File Loaded");
			return map;
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
