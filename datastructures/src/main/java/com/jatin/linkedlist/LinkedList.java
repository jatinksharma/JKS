package com.jatin.linkedlist;

public class LinkedList {
	
	public LinkedList(Integer... integers ) {
		for(int i=0; i< integers.length ; i++){
			Node n = new Node(integers[i], null);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
}



class Node{
	Integer value;
	Node next;
	
	public Node() {
	}
	
	public Node(Integer value, Node next) {
		this.value = value;
		this.next = next;
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		String s = "Value: " + value + ", Next: " + next.value;
		return s;
	}
}
