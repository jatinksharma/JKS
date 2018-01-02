package com.jatin.linkedlist;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		Node n1 = new Node(12, null);
		Node n2 = new Node(23, null);
		Node n3 = new Node(7, null);
		Node n4 = new Node(9, null);
		Node n5 = new Node(7, null);
		Node n6 = new Node(23, null);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(null);
		
		displayLL(n1);
		
		removeDuplicates(n1);
			
	}
	
	static void removeDuplicates(Node node){
		int countExt = 1; 
		Node n = node;
		
		while(n != null){
			Node m = node;
			
			// iterate countExt-1 times
			int countInternal = 1;
			while(m != null){
				if(countInternal == countExt){
					break;
				}

				if( m.value == n.value){
					System.out.println("Found duplicate " + n.value);
					//remove countInternal node and restructure LL 
					break;
				}
				m = m.next;
				countInternal++;
			}
			
			
			
			n = n.next;
			countExt++;
			
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
