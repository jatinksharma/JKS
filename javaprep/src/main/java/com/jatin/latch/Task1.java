package com.jatin.latch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Task1 implements Runnable {

	List<String> lst = new ArrayList<String>();
	
	CountDownLatch latch;

	public Task1(List<String> aList, CountDownLatch aLatch) {
		this.lst = aList;
		this.latch = aLatch;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {

			int size = lst.size();

			String s = "SSS";

			lst.add(s);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			lst.remove(s);

			int size1 = lst.size();

			System.out.println(" ##Running Task1 in thread "
					+ Thread.currentThread().getName() + (size == size1) + " ... Counting down " + (i+1));
			
			latch.countDown();

		}

	}

}
