package com.jatin.basic;//package com.java.concurrency.iterRecur;
//
//
///*
// * Write factorial for 7 and find time taken
// */
//public class FactorialRecur {
//	int temp = 1;
//
//	public int factorial(int num) {
//
//		temp = (factorial(num) * factorial(num - 1));
//
//		return temp;
//	}
//
//	public static void main(String[] args) {
//
//		FactorialIter fact = new FactorialIter();
//		
//		long lStartTime = System.nanoTime();
//		
//		fact.factorial(100000);
//		
//		long lEndTime = System.nanoTime();
//		
//		long difference = lEndTime - lStartTime;
//		
//		System.out.println("Time: " + difference);
//	}
//
//}
