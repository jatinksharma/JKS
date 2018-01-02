package com.jatin.notify;


public class TestMain {
	
	
	public static void main(String[] args) {
		
		Magazine commonMagazine = new Magazine();
		
		MagazineProducer task1 = new MagazineProducer(commonMagazine);
		
		MagazineConsumer task2 = new MagazineConsumer(commonMagazine);
		
		
		
		Thread t1 = new Thread(task1, "ProducerThread");
		
		Thread t2 = new Thread(task2, "ConsumerThread");
		
		
		t1.start();
		
		t2.start();
		
		
		
		
	}
	
}
