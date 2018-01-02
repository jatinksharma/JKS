package com.jatin.latch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TestMain {
	
	
	public static void main(String[] args) {
		CountDownLatch commonLatch = new CountDownLatch(5);
		
		List<String> commonList = new ArrayList<String>();
		
		commonList.add("AAA");
		
		commonList.add("BBB");
		
		commonList.add("CCC");
		
		commonList.add("DDD");
		
		commonList.add("EEE");
		
		Task1 task1 = new Task1(commonList, commonLatch);
		
		Task2 task2 = new Task2(commonList, commonLatch);
		
		CopyofTask2 task3 = new CopyofTask2(commonList, commonLatch);
		
		
		
		Thread t1 = new Thread(task1, "Thread 1");
		
		Thread t2 = new Thread(task2, "Thread 2");
		
		Thread t3 = new Thread(task3, "Thread 3");
		
		
		t1.start();
		
		t2.start();
		
		t3.start();
		
		
		
		
	}
	
}
