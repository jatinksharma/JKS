package com.jatin.synchronizedEx.withSynch;

import java.util.ArrayList;
import java.util.List;

public class Task1 implements Runnable{
	
	List<String> lst = new ArrayList<String>();

	public Task1(List<String> aList) {
		this.lst = aList;
	}

	@Override
	public void run() {
		for(int i=0 ; i < 5 ; i++){
			
			synchronized (lst) {
				int size = lst.size();
				
				String s = "SSS";
				
				lst.add( s );
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lst.remove(s );
				
				int size1 = lst.size();
				
				System.out.println(" ##Running Task in thread " + Thread.currentThread().getName() + ( size == size1 ));	
			}
			
			
			
			
		}
		
		
	}

}
