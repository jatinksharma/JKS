package com.jatin.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task2 implements Runnable {

	List<String> lst = new ArrayList<String>();

	CyclicBarrier barrier;

	public Task2(List<String> aList, CyclicBarrier aBarrier) {
		this.lst = aList;
		this.barrier = aBarrier;
	}

	@Override
	public void run() {

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

		try {
			
			System.out.println(" ^^Awaiting on Barrier.........\n");
			
			Thread.sleep(3000);

			
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println(" ^^barrier crossed together!");

	}

}
