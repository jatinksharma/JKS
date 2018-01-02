package com.jatin.recursion;

/*
fibonacci(0) → 0
fibonacci(1) → 1
fibonacci(2) → 1
 0, 1, 1, 2, 3, 5, 8, 13, 21
 
 
 Each subsequent value is the sum of the previous two values
 The first two values in the sequence are 0 and 1 (essentially 2 base cases).
 */
public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(recurFibonacci(6));
		System.out.println(iterFibonacci(6));
	}
	
	static int iterFibonacci(int n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}
		
		int a = 0;
		int b = 1;
		int sum = 0;
		
		for(int i=1; i < n; i++){
			sum = a + b;
			a = b;
			b = sum;
		}
		
		return sum;
		
	}
	
	static int recurFibonacci(int n) {
		
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		
		return recurFibonacci(n-1) + recurFibonacci(n -2);
		
	}
	
	
	

}
