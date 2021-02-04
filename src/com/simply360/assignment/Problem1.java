package com.simply360.assignment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.regex.Pattern;

public class Problem1 {

	
	
	
	public static Map<String, List<String>> getMatchResults(List<String> regexList, List<String> strings) {
		
		if(regexList==null || regexList.size()==0)
			  throw new IllegalArgumentException("Please give a valid regex list");
		
		if(strings==null || strings.size()==0)
			 throw new IllegalArgumentException("Please give a valid strings list");
		

		/*
		 Considering one string may match with more than one regex pattern
		*/
		
		Map<String, List<String>>results= new LinkedHashMap<String, List<String>>();  
		
		for(String regex: regexList)
		{
			List<String> matchResults=getMatchResults(regex,strings);
			if(matchResults!=null)
				 results.put(regex, matchResults);
		}

		
		
		 
		 
	
		
		return results;
		
		
	}
	
	public static List<String> getMatchResults(String regex, List<String> strings) {
		
		
		List<String> results= new ArrayList<String>();
		
		if(regex==null )
			  throw new IllegalArgumentException("Please give a valid regex ");
		
		if(strings==null || strings.size()==0)
			 throw new IllegalArgumentException("Please give a valid strings list");
		
		for(String str: strings)
			 if(Pattern.matches(regex, str))
				   results.add(str);
		
		
		
		return results.size()==0? null:results;
		
	}
	
}
