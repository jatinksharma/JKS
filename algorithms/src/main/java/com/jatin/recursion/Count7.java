package com.jatin.recursion;

/*
  	count7(717) → 2
	count7(7) → 1
	count7(123) → 0
 */
public class Count7 {

	public static void main(String[] args) {
		System.out.println(count7(717));
		System.out.println(count7(7));
		System.out.println(count7(123));
		System.out.println(count7(7777));
	}
	
	static int count7(int num){
		int count = 0;
		
		if(num == 0){
			return 0;
		}
		
		int units = num%10;
		
		
		if(units == 7){
			count++;
		}
		
		return count7(num/10) + count;
		
		
		
	}
	
	
	
}
