package edu.frcc.csc1060j.SearchEngine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jsoup.select.Elements;

public class Index
{
	private Map<String, Set<TermCounter>> index = new HashMap<>();

	public void indexPage(String url, Elements paragraphs)
	{
		TermCounter tc = new TermCounter(url);
		tc.processElements(paragraphs);
		
		for(String key : tc.getKeySet())
		{
			add(key, tc);
		}
	}

	private void add(String term, TermCounter tc)
	{
		Set<TermCounter> set = index.get(term);
		if(set == null) 
		{
			set = new HashSet();
			index.put(term, set);
		}
		set.add(tc);
	}
	
	public String get(String term)
	{
		Set<TermCounter> stc = index.get(term);
		StringBuilder sb = new StringBuilder();
		
		for (TermCounter tc : stc)
		{
			sb.append("\n\t" + tc.getURL());
		}
		return sb.toString();
	}
	
	public void printIndex()
	{
		for(String term : index.keySet())
		{
			System.out.println(term);
			Set<TermCounter> stc = index.get(term);
			for(TermCounter tc : stc)
			{
				System.out.println("\t\t" + tc.getURL() 
				+ " " + tc.get(term));
			}
		}
	}
}
