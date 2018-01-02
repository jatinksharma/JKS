package com.jatin.recursion;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(printFacttorial(5));
	}
	
	static int printFacttorial(int num){
		if(num == 0){
			return 1;
		}
		
		return printFacttorial(num-1) * (num);
		
		
	}
	
	
	
	
}
