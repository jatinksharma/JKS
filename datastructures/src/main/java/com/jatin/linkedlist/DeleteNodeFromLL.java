package com.jatin.linkedlist;

public class DeleteNodeFromLL {
	
	
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
		
		displayLL(n1);
		
		deleteNthNode(n1, 4);
		
		displayLL(n1);
		
	}
	
	static void displayLL(Node n){
		System.out.println("\n");
		while(n != null){
			System.out.print(n.getValue() + " --> ");
			n = n.next;
		}
	}
	
	static void deleteNthNode(Node node, int n){
		int counter = 0;
		while(node != null){
			counter ++;
			if((n-1) == counter){
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}
	}
	
}
