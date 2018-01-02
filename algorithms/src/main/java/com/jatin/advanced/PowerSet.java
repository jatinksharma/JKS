package com.jatin.advanced;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


// Iterative
public class PowerSet {
	
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		lst.add("A");lst.add("B");lst.add("C");lst.add("D");
		
		List<List<String>> powerList = powerSet1(lst);
		
		for(List<String> l : powerList){
			System.out.print("[");
			for(String s: l){
				System.out.print(s + " ");
			}
			System.out.print("]");
		}
	}

	public static List<List<String>> powerSet1(List<String> originalSet){
		List<List<String>> ps = new ArrayList<List<String>>();
		List<String> emptyList = new ArrayList<String>();
		ps.add(emptyList);
		
		for(String element: originalSet){
			
			List<List<String>> newPS = new ArrayList<List<String>>();
			
			for(List<String> subset: ps){
				newPS.add(subset);
				
				List<String> newSubset = new ArrayList<String>(subset);
				newSubset.add(element);
				
				newPS.add(newSubset);
				
			}
			
			ps = newPS;
			
		}
		
		return ps;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static <T> List<List<T>> powerset(Collection<T> list) {
		  List<List<T>> ps = new ArrayList<List<T>>();
		  ps.add(new ArrayList<T>());   // add the empty set
		 
		  // for every item in the original list
		  for (T item : list) {
		    List<List<T>> newPs = new ArrayList<List<T>>();
		 
		    for (List<T> subset : ps) {
		      // plus the subsets appended with the current item
		      List<T> newSubset = new ArrayList<T>(subset);
		      newSubset.add(item);
		      
		      // copy all of the current powerset's subsets
		      newPs.add(subset);
		      
		      newPs.add(newSubset);
		    }
		 
		    // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
		    ps = newPs;
		  }
		  return ps;
		}
		 
	
}
