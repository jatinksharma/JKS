package com.jatin.threads;

public class TestMain {

	public static void main(String[] args) {

		Task1 task1 = new Task1();

		Task2 task2 = new Task2();

		Thread t1 = new Thread(task1, "Thread 1");

		Thread t2 = new Thread(task2, "Thread 2");

		t1.start();

		t2.start();
		
		System.out.println("Finish!");
	}

}
