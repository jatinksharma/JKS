package com.jatin.threads;

public class Task1 implements Runnable{
	
	


	@Override
	public void run() {
		for(int i=0 ; i < 5 ; i++){
			System.out.println(this.getClass() + " ##Running Task in thread " + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}
