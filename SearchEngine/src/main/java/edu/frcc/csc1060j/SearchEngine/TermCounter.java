package edu.frcc.csc1060j.SearchEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class TermCounter
{
	private Map<String, Integer> map;
	private String url;
	
	public TermCounter(String url)
	{
		this.url = url;
		map = new HashMap<>();
	}
	
	public Integer get(String term)
	{
		Integer count = map.get(term);
		int cnt = count == null ? 0 : count;
		return cnt;
	}
	public String getURL()
	{
		return url;
	}
	
	public Set<String> getKeySet()
	{
		return map.keySet();
	}
	
	public void processElements(Elements paras)
	{
		for(Node node : paras)
		{
			processTree(node);
		}
	}
	
	private void processTree(Node root)
	{
		for(Node node: new WikiNodeIterable(root))
		{
			if(node instanceof TextNode)
			{
				processText(((TextNode) node).text());
			}
		}
	}
	
	private void processText(String text)
	{
		// Replace all punction with empty string, convert to lowercase,
		// And split on one ore more spaces.
		String[] tokens = text.replace("\\pP", "").toLowerCase().split("\\s+");
		for(int i = 0; i < tokens.length; i++)
		{
			String term = tokens[i];
			incrementtermCount(term);
		}
		
		
	}
	
	private void incrementtermCount(String term)
	{
		Integer count = map.get(term);
		int cnt = count == null? 0 : count;
//		int cnt;
//		if(count == null)
//		{
//			cnt = 0;
//		}
//		else
//		{
//			cnt = count;
//		}
		map.put(term, ++cnt);
		
	}
	
	public void printCounts()
	{
		for(String key : map.keySet())
		{
			int count = map.get(key);
			System.out.println(key + "," + count);
		}
		System.out.println("Number of terms: " + map.size());
	}


}
