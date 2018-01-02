package com.jatin.linkedlist;

public class MergeLL {
	
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
		n6.setNext(null);
		
		Node n11 = new Node(8, null);
		Node n12 = new Node(6, null);
		Node n13 = new Node(30, null);
		Node n14 = new Node(21, null);
		Node n15 = new Node(15, null);
		Node n16 = new Node(41, null);
		
		n11.setNext(n12);
		n12.setNext(n13);
		n13.setNext(n14);
		n14.setNext(n15);
		n15.setNext(n16);
		n16.setNext(null);
		
		displayLL(n1);
		
		displayLL(n11);
		
		mergeOnNthPosition(4, n1, n11);
		
		displayLL(n1);

	}
	
	static void mergeOnNthPosition(int pos, Node n, Node m){
		Node temp = null;
		int count = 1;
		while(n != null){
			if(count == pos){
				temp = n.next;
				n.next = m;
				break;
			}
			n = n.next;
			count++;
		}
		
		while(n != null){
			if(n.next == null){
				n.next = temp;
				break;
			}
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
