package com.jatin.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class TestMain {
	
	
	public static void main(String[] args) {
		CyclicBarrier commonBarrier = new CyclicBarrier(2);
		
		List<String> commonList = new ArrayList<String>();
		
		commonList.add("AAA");
		
		commonList.add("BBB");
		
		commonList.add("CCC");
		
		commonList.add("DDD");
		
		commonList.add("EEE");
		
		Task1 task1 = new Task1(commonList, commonBarrier);
		
		Task2 task2 = new Task2(commonList, commonBarrier);
		
		
		
		Thread t1 = new Thread(task1, "Thread 1");
		
		Thread t2 = new Thread(task2, "Thread 2");
		
		
		t1.start();
		
		t2.start();
		
		
		
		
	}
	
}
