package com.jatin.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllSubSets {
	public static void main(String[] args) {
		Set<Integer> originalSet = new HashSet<Integer>();
		originalSet.add(1);
		originalSet.add(2);
		originalSet.add(3);

		Set<Set<Integer>> newSet = powerSet(originalSet);
		for (Set<Integer> s : newSet) {
			for (Integer i : s) {
				System.out.print(i + "\t");
			}
			System.out.println("");
		}
	}

	public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
		Set<Set<T>> sets = new HashSet<Set<T>>();
		
		if (originalSet.isEmpty()) {
			sets.add(new HashSet<T>());
			System.out.println("Added empty set");
			return sets;
		}
		
		List<T> list = new ArrayList<T>(originalSet);

		T head = list.get(0);
		Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
		
		System.out.println("Head: " + head + ", Rest: " + rest);
		
		Set<Set<T>> powerSet = powerSet(rest);
		
		System.out.println("\nProcessing powerset: " + powerSet);
		
		for (Set<T> rest1 : powerSet) {
			Set<T> newSet = new HashSet<T>();
			
			newSet.add(head);
			newSet.addAll(rest1);
			
			sets.add(newSet);
			
			sets.add(rest1);
			
			System.out.println("Head: " + head + ", Set: "	+ rest1 + ", therefore NewSet: " + newSet + " and Set: " + rest1  + " becomes Sets:" + sets );
			
		}
		return sets;
	}
}
