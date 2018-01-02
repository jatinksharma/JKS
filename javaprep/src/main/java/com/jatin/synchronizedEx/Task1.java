package com.jatin.synchronizedEx;

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
			int size = lst.size();
			
			lst.add( i + "ABC" );
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			lst.remove(i + "ABC" );
			
			int size1 = lst.size();
			
			System.out.println(" ##Running Task in thread " + Thread.currentThread().getName() + ( size == size1 ));
			
			
		}
		
		
	}

}
