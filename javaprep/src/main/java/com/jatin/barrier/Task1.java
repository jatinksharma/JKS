package com.jatin.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Task1 implements Runnable {

	List<String> lst = new ArrayList<String>();
	
	CyclicBarrier barrier;

	public Task1(List<String> aList, CyclicBarrier aBarrier) {
		this.lst = aList;
		this.barrier = aBarrier;
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
					+ Thread.currentThread().getName() + (size == size1));
		}
		
		try {
			System.out.println(" ##Awaiting on Barrier.........\n");
			
			Thread.sleep(3000);
			
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(" ##barrier crossed together!");

	}

}
