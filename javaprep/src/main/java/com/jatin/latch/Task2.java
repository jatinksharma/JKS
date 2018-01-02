package com.jatin.latch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Task2 implements Runnable {

	List<String> lst = new ArrayList<String>();

	CountDownLatch latch;

	public Task2(List<String> aList, CountDownLatch aLatch) {
		this.lst = aList;
		this.latch = aLatch;
	}

	@Override
	public void run() {
		try {
			System.out.println(" ^^ Waiting on Latch for Countdown to complete.......");
			
			latch.await();
			
			System.out.println(" ^^ Latch for Countdown complete.......proceeding now!");
			
			for (int i = 0; i < 15; i++) {

				int size = lst.size();

				String p = "PPP";

				lst.add(p);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				lst.remove(p);

				int size1 = lst.size();

				System.out.println(" ^^Running Task2 in thread "
						+ Thread.currentThread().getName() + (size == size1));

			}
			
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		

	}

}
