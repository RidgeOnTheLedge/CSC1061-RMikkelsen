package edu.frcc.csc1060j.SearchEngine;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.select.Elements;

public class Driver
{
	private static Scanner scnr = new Scanner(System.in);
	public static void main(String args[]) throws IOException
	{
		WikiFetcher wf = new WikiFetcher();
		Index index = new Index();
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Elements paragraphs = wf.fetchWikipedia(url);
//		TermCounter tc = new TermCounter(url);
//		tc.processElements(paragraphs);
//		tc.printCounts();
		index.indexPage(url, paragraphs);
//		index.printIndex();
		
		
		url = "https://it.wikipedia.org/wiki/Pagina_principale";
		paragraphs = wf.fetchWikipedia(url);
		index.indexPage(url, paragraphs);
		index.printIndex();
		System.out.println("Enter search term: ");
		String term = scnr.next().toLowerCase();
		System.out.println(index.get(term));
		
	}
}

