package com.jatin.synchronizedEx;

import java.util.ArrayList;
import java.util.List;



public class Task2 implements Runnable{
	
	List<String> lst = new ArrayList<String>();

	public Task2(List<String> aList) {
		this.lst = aList;
	}

	@Override
	public void run() {
		for(int i=0 ; i < 15 ; i++){
			int size = lst.size();
			
			lst.add( i + "XYZ" );
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			lst.remove(i + "XYZ" );
			
			int size1 = lst.size();
			
			System.out.println(" ^^Running Task in thread " + Thread.currentThread().getName() + ( size == size1 ));
			
		}
		
		
	}

}
