package com.jatin.linkedlist;

public class FindLoopInLL {
	
	public static void main(String[] args) {
		Node n1 = new Node(12, null);
		Node n2 = new Node(23, null);
		Node n3 = new Node(7, null);
		Node n4 = new Node(9, null);
		Node n5 = new Node(11, null);
		Node n6 = new Node(43, null);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n3);//loop

		findLoopInLL(n1);

	}
	
	static void findLoopInLL(Node n){
		Node m1 = n;
		Node m2 = n.next.next;
		
		while(n != null){
			System.out.println(m1 + " \tAND\t " + m2);
			
			if(m1.equals(m2)){
				System.out.println("Loop found at " + m1.getValue());
				break;
			}
			
			m1 = m1.next;
			m2 = m2.next.next;
			
			n = n.next;
		}
	}
	
	
	static void displayLL(Node n){
		System.out.println("\n");
		while(n != null){
			System.out.print(n.getValue() + " --> ");
			n = n.next;
		}
	}
	
}
