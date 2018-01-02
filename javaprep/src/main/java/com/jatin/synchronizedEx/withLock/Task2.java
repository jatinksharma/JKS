package com.jatin.synchronizedEx.withLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Task2 implements Runnable{
	
	List<String> lst = new ArrayList<String>();
	
	Lock lock = new ReentrantLock();

	public Task2(List<String> aList, Lock aLock) {
		this.lst = aList;
		this.lock = aLock;
	}

	@Override
	public void run() {
		for(int i=0 ; i < 15 ; i++){
			
			lock.lock();
			try{
				int size = lst.size();
				
				String p = "PPP";
				
				lst.add( p );
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lst.remove(p);
				
				int size1 = lst.size();
				
				System.out.println(" ^^Running Task in thread " + Thread.currentThread().getName() + ( size == size1 ));
			}finally{
				lock.unlock();
			}
			
			
			
		}
		
		
	}

}
