package com.jatin.basic;

public class ClosestPerfectSq {
	
	public static void main(String[] args) {
		System.out.println("" + 102.234d);
		
		System.out.println("" +findClosestPerfectSq(102.234d));
		
		System.out.println("" + 102.789d);
		
		System.out.println("" +findClosestPerfectSq(102.789d));
		
		System.out.println("" + 120.234d);
		
		System.out.println("" +findClosestPerfectSq(120.234d));
		
		
	}
	
	static double findClosestPerfectSq(Double d){
		
		Double sqrt = Math.sqrt(d);
		
//		System.out.println(sqrt);
		
		Double decimalPart = sqrt % 1d;
		
//		System.out.println(decimalPart);
		
		if(decimalPart > 0.5d){
//			System.out.println("here");
			return Math.ceil(sqrt);
		}else{
//			System.out.println("there");
			return Math.floor(sqrt);
		}
	}
}
