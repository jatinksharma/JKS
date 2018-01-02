package com.jatin.advanced;

import java.util.Set;
import java.util.TreeSet;

public class AllPermutations {
	public static void main(String[] args) {
		
		
		for(String s: permute("abcd")){
			System.out.println(s);
		}
	}
	public static Set<String> permute(String sampleString) {
		// Use sets to eliminate semantic duplicates (aab is still aab even if
		// you switch the two 'a's)
		// Switch to HashSet for better performance
		Set<String> set = new TreeSet<String>();

		// Termination condition: only 1 permutation for a string of length 1
		if (sampleString.length() == 1) {
			System.out.println("Added single string " + sampleString);
			System.out.println("\tSet Before: " + set);
			set.add(sampleString);
			System.out.println("\tSet After: " + set);
			System.out.println("\n");
		} else {
			// Give each character a chance to be the first in the permuted
			// string
			System.out.println("\nSample string " + sampleString);
			for (int i = 0; i < sampleString.length(); i++) {
				// Remove the character at index i from the string
				String pre = sampleString.substring(0, i);
				String post = sampleString.substring(i + 1);

				String remaining = pre + post;
				
				System.out.println("\t1st char " + sampleString.charAt(i));
				System.out.println("\tPre " + pre);
				System.out.println("\tPost " + post);
				System.out.println("\tRemaining " + post);
				
				Set<String> s1 = permute(remaining);

				// Recurse to find all the permutations of the remaining chars
				for (String permutation : s1) {
					// Concatenate the first character with the permutations of
					// the remaining chars
					System.out.println("\tSet Before: " + set);
					System.out.println("\tAdded " + sampleString.charAt(i) + permutation);
					set.add(sampleString.charAt(i) + permutation);
					System.out.println("\tSet After: " + set);
				}
			}
		}
		return set;
	}
}
