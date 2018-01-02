package com.jatin.threads;

public class Task2 implements Runnable{
	

	@Override
	public void run() {
		for(int i=0 ; i < 15 ; i++){
			System.out.println(this.getClass() + " ^^Running Task in thread "  + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}
