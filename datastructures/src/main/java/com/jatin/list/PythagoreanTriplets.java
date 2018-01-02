package com.jatin.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PythagoreanTriplets {
	
	static List<Integer> list = new ArrayList<Integer>();
	
	/**
	 * Pythagorean Triplets
	 * 5, 12, 13
	 * 3, 4, 5
	 * @param args
	 */
	public static void main(String[] args) {
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(7);
		list.add(9);
		list.add(5);
		list.add(11);
		
		System.out.println(containsPythTriplets());
	}
	
	// best case = nlog(n)
	// worst case = nlog(n) + n2
	static boolean containsPythTriplets(){
		// O(n) = nlog(n)
		Collections.sort(list);
		
		boolean hasTriplet = false;
		
		// O(n) worst case = n2
		// O(n) best case = 1
		for(int i=0; i<list.size() ; i++){
			
			Integer a = list.get(i);
			
			// take ith element
			// loop from i + 1 th element till size and get numbers
			for(int j= i+1, k = i+2; k<list.size(); j++, k++){
				Integer b = list.get(j);
				Integer c = list.get(k);
				
				// check c2 = b2 + a2;
				hasTriplet = (c*c == a*a + b*b)? true : false ;
				
				break;
			}
			
			if(hasTriplet){
				break;
			}
			
		}
		
		return hasTriplet;
	}
	
	
}
