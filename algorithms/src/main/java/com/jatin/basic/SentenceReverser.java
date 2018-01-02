package com.jatin.basic;

import java.util.Arrays;
import java.util.StringTokenizer;

public class SentenceReverser{
	
	public static void main(String[] args){
		String test = "Sample string to test";
		
//		String output = reverseString(test); // "elpmaS gnirts ot tset"
//		
//		System.out.println(output);
		
		System.out.println(recurReverse(test));
		
	}
	
	
	
	static String recurReverse(String s){
		if(s.isEmpty()){
			return s;
		}
		
		return recurReverse(s.substring(1)) + s.charAt(0);
		
	}
	
	// tokenize
	static String reverseString(String s){
		StringBuilder sbuff = new StringBuilder(s.length());
	
		StringTokenizer tokens = new StringTokenizer(s, " ");
		
		while(tokens.hasMoreElements()){
			sbuff.append(reverseWord((String) tokens.nextElement()) + "   ");
		}
		
		return sbuff.toString();
	}
	
	// for every word
	static String reverseWord(String s){
		char[] arr = s.toCharArray();
		
		for(int i=0, j= arr.length-1; i< arr.length/2 ; i++, j--){
			char a = arr[i];
			arr[i] = arr[j];
			arr[j] = a;
		}
		
		return Arrays.toString(arr).replace("[", "").replace("]", "").replace(",", "").trim();
	}
	

}