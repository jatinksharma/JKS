package com.jatin.basic;

import java.util.Random;

public class Rand7UsingRand5 {
	
	public static void main(String[] args) {
		System.out.println(rand5());
		System.out.println(rand5());
		System.out.println(rand7());
		System.out.println(rand7());
	}
	
	static int rand5(){
		Random r = new Random();
		return r.nextInt(5);
	}
	
	static int rand7() {
	    while (true) {
	        int num = 5*(rand5()-1) + rand5();
	        if (num < 22) return ((num % 7) + 1);
	    }
	}
}
