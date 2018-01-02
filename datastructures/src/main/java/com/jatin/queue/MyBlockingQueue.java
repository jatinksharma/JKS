package com.jatin.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("unchecked")
public class MyBlockingQueue<E> implements Iterable<E> {

	private E[] queue;
	private int capacity;
	private int tailIndex = 0;
	private int headIndex = 0;
	private int currSize = 0;
	private RegularQueueIterator iterator = new RegularQueueIterator();
	// private static final int DEFAULT_CAPACITY = Integer.MAX_VALUE;
	// private static final float LOAD_FACTOR = 0.75f;
	// private static final float GROW_FACTOR = 0.50f;

	/* Blocking features */
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition notEmpty = lock.newCondition();
	private final Condition notFull = lock.newCondition();

	public static void main(String[] args) {
		MyBlockingQueue<String> q = new MyBlockingQueue<String>(20);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		Publisher publisher = new Publisher(q);
		Consumer consumer = new Consumer(q);
		executor.execute(publisher);
		executor.execute(consumer);
	}

	
	public Iterator<E> iterator() {
		return iterator;
	}

	private class RegularQueueIterator implements Iterator<E> {
		private int position;

		
		public boolean hasNext() {
			return (position < size()) ? true : false;
		}

		
		public E next() {
			Object nextObj = queue[position];
			position++;
			return (E) nextObj;
		}

		
		public void remove() {
			queue[position] = null;
		}

	}

	int circularIncrement(int index) {
		return (++index == queue.length) ? 0 : index;
	}

	public boolean add(E e) {
		boolean inserted = false;

		lock.lock();
		try {
			System.out.println("Publish: " + e);
			
			while (currSize == capacity) {
				System.out.println("X WAIT:Publisher");
				notFull.await();
				System.out.println("Y proceed:Publisher");
			}

			// It is a bounded buffer, therefore commenting out below
			// if (currSize == (LOAD_FACTOR * currentInitializedSize)) {
			// grow();
			// }

			queue[tailIndex] = e;
			tailIndex = circularIncrement(tailIndex);

			currSize++;

			notEmpty.signal();

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}

		return inserted;
	}

	public E remove() {
		E head = null;

		lock.lock();
		try {
			
			while (currSize == 0) {
				System.out.println("X WAIT:CONSUMER");
				notEmpty.await();
				System.out.println("Y proceed:CONSUMER");
			}

			head = queue[headIndex];
			System.out.println("\t\tConsume: " + queue[headIndex]);
			queue[headIndex] = null;
			headIndex = circularIncrement(headIndex);
			;

			currSize--;

			notFull.signal();

		} catch (InterruptedException e) {

			e.printStackTrace();
		} finally {
			lock.unlock();
		}

		return head;
	}

	public int size() {
		return currSize;
	}

	public boolean isEmpty() {
		return ((size() == 0) ? true : false);
	}

	public boolean contains(Object o) {

		return false;
	}

	// public MyBlockingQueue() {
	// this.capacity = DEFAULT_CAPACITY;
	// queue = (E[]) new Object[capacity];
	// }

	public MyBlockingQueue(int initialSize) {
		this.capacity = initialSize;
		queue = (E[]) new Object[capacity];
	}

	// private void grow() {
	// capacity = (int) (capacity + (capacity * GROW_FACTOR));
	// queue = Arrays.copyOf(queue, capacity);
	// }

	private static class Publisher implements Runnable {
		MyBlockingQueue<String> qu;

		public Publisher(MyBlockingQueue<String> qu) {
			this.qu = qu;
		}

		
		public void run() {
			System.out.println("Started publisher");
			for (int i = 0; i < 5000; i++) {
				if (i % 2 == 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				qu.add("hello" + i);

			}

		}

	}

	private static class Consumer implements Runnable {

		MyBlockingQueue<String> qu;

		public Consumer(MyBlockingQueue<String> qu) {
			this.qu = qu;
		}

		
		public void run() {
			System.out.println("Started consumer");
			for (;;) {
				qu.remove();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
