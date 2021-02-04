package com.simply360.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestProbelms {

	public static void main(String[] args) {


		String[] inputStrins= {
				"The patient should be informed of his therapeutic options.",
				"It wouldn't be as if the lone astronaut would be completely by himself.",
				"Now, a writer is entitled to have a Roget on his desk.",
				"Somebody should let you borrow their book",
				"From the earliest times until about the 1960s" ,
				"whether we may not, nay ought not, to use a neutral pronoun relative" ,
				"phone 9280018281" ,
				"Notionalplurality" ,
				"A starting point would be to give more support" ,
		"abc@gmail.com"};

		List<String> strings= Arrays.asList(inputStrins);

		String[] inputRegexList= {
				".*\\.$" , 
				".*\\d{10}.*",
				".*@.*",
				"\\w+",
		".*\\s.*"};

		List<String> regexList= Arrays.asList(inputRegexList);


		/*	
		 We are using static methods, because we are not dealing with any objects ( states )
		 */

		System.out.println("problem 1 ----------------------");

		testProblem1(regexList, strings);  // problem 1

		System.out.println("problem 2 ----------------------");


		testProblem2(regexList, strings ); // problem 2


		System.out.println("problem 3 ----------------------");

		int[] arr= {0, 1, 5, 8, 14, 18, 44, 81, 89, 99, 102};
		int first=8, second=18;

		testProblem3(arr, first, second);




	}

	public static void testProblem1(List<String> regexList, List<String> strings) {
		Map<String, List<String>>	results=Problem1.getMatchResults(regexList, strings);

		for( Entry<String, List<String>> e: results.entrySet())
			System.out.println("regex "+e.getKey()+" ---> matches with ----> "+e.getValue());
		// we can format the print result
	}

	public static void testProblem2(List<String> regexList, List<String> strings) {
		Problem2.printMatchResults(regexList, strings); // problem 2
	}

	public static void testProblem3(int[] arr, int first, int second) {	
		System.out.println(Problem3.findBetweenNumbersCount(arr,first,second));		
	}

}
