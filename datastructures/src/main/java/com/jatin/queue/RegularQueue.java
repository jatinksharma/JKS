package com.jatin.queue;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class RegularQueue<E> implements Iterable<E> {
	
	private E[] queue;
	private int currentInitializedSize;
	private int tailIndex = 0;
	private int headIndex = 0;
	private int currSize = 0;
	private RegularQueueIterator iterator = new RegularQueueIterator();
	private static final int DEFAULT_CAPACITY = 32;
	private static final float LOAD_FACTOR = 0.75f;
	private static final float GROW_FACTOR = 0.50f;
	
	public static void main(String[] args) {
		RegularQueue<String> q = new RegularQueue<String>();
		
		for(int i=0; i<50 ; i++){
			q.add("hello"+i);
		}
		
		System.out.println(q.size());
	}
	
	@Override
	public Iterator<E> iterator() {
		return iterator;
	}
	
	private class RegularQueueIterator implements Iterator<E>{
		private int position;
		
		@Override
		public boolean hasNext() {
			return (position < size())? true: false;
		}

		@Override
		public E next() {
			Object nextObj = queue[position];
			position++;
			return (E)nextObj;
		}

		@Override
		public void remove() {
			queue[position] = null;
		}
		
	}
	
	public boolean add(E e) {
		boolean inserted = false;
		
		if( currSize == (LOAD_FACTOR * currentInitializedSize)){
			grow();
		}
		
		queue[tailIndex] = e;
		tailIndex++;
		
		currSize++;
		
		return inserted;
	}
	
	
	
	public E remove() {
		E head = null;
		
		if(currSize > 0){
			head = queue[headIndex];
			queue[headIndex] = null;
			headIndex ++ ;
			
			
			currSize--;
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

	
	
	
	
	public RegularQueue() {
		this.currentInitializedSize = DEFAULT_CAPACITY;
		queue = (E[])new Object[currentInitializedSize];
	}
	
	public RegularQueue(int initialSize) {
		this.currentInitializedSize = initialSize;
		queue = (E[])new Object[currentInitializedSize];
	}
	
	private void grow(){
		currentInitializedSize = (int) (currentInitializedSize + (currentInitializedSize * GROW_FACTOR));
		queue = Arrays.copyOf(queue, currentInitializedSize);
	}
	
}
