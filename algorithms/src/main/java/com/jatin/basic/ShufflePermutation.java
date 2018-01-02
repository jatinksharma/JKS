package com.jatin.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ShufflePermutation {

	public static void main(String[] args) {
		String toPermute = "DELHI";

		Long t1 = System.nanoTime();
		permute(toPermute);
		Long t2 = System.nanoTime();
		System.out.println(t2-t1);
		
		System.out.println("\n\n");
		
		Long t3 = System.nanoTime();
		permute1(toPermute);
		Long t4 = System.nanoTime();
		System.out.println("");
		System.out.println(t4-t3);
		
		System.out.println(((double)(t4-t3)-(t2-t1))/1000000000);
	}
	
	static void permute(String toPermute) {
		int fact = factorial(toPermute.length());

		System.out.println("Total Permutations: " + fact + "\n");

		Set<String> permutations = new TreeSet<String>();

		ArrayList<String> lst = new ArrayList<String>();

		
		while (permutations.size() != fact) {
			
			ArrayList<String> strLst = converStringToList(toPermute);
			shuffle(strLst, lst);
			String s = convertListToString(lst);

			if (!permutations.contains(s)) {
				permutations.add(s);
			}

			lst.clear();
		}
		
		printSet(permutations);
	}

	static void permute1(String toPermute) {
		
		int fact = factorial(toPermute.length());

		System.out.println("Total Permutations: " + fact + "\n");
		
		Set<ArrayList<String>> permutations1 = new HashSet<ArrayList<String>>();

		ArrayList<String> lst = new ArrayList<String>();
		
		while (permutations1.size() != fact) {
			
			ArrayList<String> strLst = converStringToList(toPermute);
			
			shuffle(strLst, lst);

			permutations1.add(new ArrayList<String>(lst));
			
			lst.clear();
		}

		printSet1(permutations1);
	}

	static ArrayList<String> converStringToList(String s) {
		char[] charArr = s.toCharArray();
		ArrayList<String> lst = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			lst.add(Character.toString(charArr[i]));
		}
		return lst;
	}

	static String convertListToString(ArrayList<String> strLst) {
		StringBuilder sBuff = new StringBuilder(strLst.size());
		for (int i = 0; i < strLst.size(); i++) {
			sBuff.append(strLst.get(i));
		}

		return sBuff.toString();
	}

	static int factorial(int n) {
		int fact = 1;
		for (int i = n; i > 0; i--) {
			fact = fact * n;
			n = n - 1;
		}
		return fact;
	}

	static void shuffle(ArrayList<String> cards, ArrayList<String> shuffledCards) {
		Random randmo = new Random();
		int index = 0;
		if (cards.size() != 0) {
			index = randmo.nextInt(cards.size());
			shuffledCards.add(cards.remove(index));
			shuffle(cards, shuffledCards);
		}
	}

	static void printSet(Set<String> set) {
		for (String s : set) {
			System.out.println(s);

		}
	}
	
	static void printSet1(Set<ArrayList<String>> set) {
		for (ArrayList<String> s : set) {
			System.out.println("");
			for (String ss : s) {
				System.out.print(ss);

			}
		}
	}

}
