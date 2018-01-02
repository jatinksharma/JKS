package com.jatin.classloader;

import java.util.*;

public class ShuffleCards {
	public static void main(String[] args) {
		args = new String[10];
		args[0] = "AA";
		args[1] = "BB";
		args[2] = "CC";
		args[3] = "DD";
		args[4] = "EE";
		args[5] = "FF";
		args[6] = "GG";
		args[7] = "HH";
		args[8] = "II";
		args[9] = "JJ";

		printArr(args);

		System.out.println("\n");

		for (int i = 0; i < 5; i++) {
			printArr(shuffle(args));
			System.out.println("\n");
		}
		
		shuffleCards(new ArrayList<String>(Arrays.asList(args)));
		
		System.out.println("\n**\n");
		ArrayList<String> strLst = new ArrayList<String>();
		shuffleCards(new ArrayList<String>(Arrays.asList(args)), strLst);
//		System.out.println(strLst);
for(String s: strLst){
	System.out.print(" " + s);
}
		
	}

	static String[] shuffle(String[] deck) {
		int deckSize = deck.length;
		String[] shuffledDeck = new String[deckSize];

		Set<Integer> deckLocations = new HashSet<Integer>();

		for (String s : deck) {
			int location = getRandomNum(deckSize);
			while (deckLocations.contains(location)) {
				location = getRandomNum(deckSize);
			}
			
			if(deck[location].equalsIgnoreCase(s)){
				int location1;
				while (true) {
					location1 = getRandomNum(deckSize);
					if(location1 != location && !deckLocations.contains(location)){
						break;
					}
				}
				location = location1;
			}
			
			shuffledDeck[location] = s;
			deckLocations.add(location);
		}

		return shuffledDeck;

	}

	static int getRandomNum(int boundary) {
		Random r = new Random();
		return r.nextInt(boundary);
	}

	static void printArr(String[] args) {
		for (String s : args) {
			System.out.print(" " + s);
		}
	}

	static void shuffleCards(ArrayList<String> cards) {
		Random randmo = new Random();
		int index = 0;
		if (cards.size() != 0) {
			index = randmo.nextInt(cards.size());
			System.out.print(" " + cards.get(index));
			cards.remove(index);
			shuffleCards(cards);
		}
	}
	
	static void shuffleCards(ArrayList<String> cards, ArrayList<String> shuffledCards) {
		Random randmo = new Random();
		int index = 0;
		if (cards.size() != 0) {
			index = randmo.nextInt(cards.size());
			shuffledCards.add(cards.remove(index));
			shuffleCards(cards, shuffledCards);
		}
	}

}
