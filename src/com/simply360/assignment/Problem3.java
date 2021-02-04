package com.simply360.assignment;

public class Problem3 {

	public static void main(String[] args) {
		
		int[] arr= {0, 1, 5, 8, 14, 18, 44, 81, 89, 99, 102};
		int first=8, second=18;
		
		System.out.println(findBetweenNumbersCount(arr,first,second));
	}
	
	public static int findBetweenNumbersCount(int[] arr, int first, int second) {
		
			// array is sorted
		
			int i=0, j=arr.length-1;
		
			while(arr [i]<first)
				  i++;
			while(arr[j]>second)
				  j--;
		
			return (j-i)+1;// length
	}
	
}
