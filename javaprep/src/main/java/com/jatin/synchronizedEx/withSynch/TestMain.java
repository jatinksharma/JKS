package com.jatin.synchronizedEx.withSynch;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
	
	
	public static void main(String[] args) {
		List<String> commonList = new ArrayList<String>();
		
		commonList.add("AAA");
		
		commonList.add("BBB");
		
		commonList.add("CCC");
		
		commonList.add("DDD");
		
		commonList.add("EEE");
		
		Task1 task1 = new Task1(commonList);
		
		Task2 task2 = new Task2(commonList);
		
		
		
		Thread t1 = new Thread(task1, "Thread 1");
		
		Thread t2 = new Thread(task2, "Thread 2");
		
		
		t1.start();
		
		t2.start();
		
		
		
		
	}
	
}
