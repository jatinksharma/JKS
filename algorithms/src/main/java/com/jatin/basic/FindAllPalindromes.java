package com.jatin.basic;

public class FindAllPalindromes {
	public static void main(String[] args) {
		FindAllPalindromes finder = new FindAllPalindromes();
		finder.printAllPalindromes("abcddcbaABCDEDCBA");
	}

	public void printAllPalindromes(String inputText) {
		if (inputText == null) {
			System.out.println("Input cannot be null!");
			return;
		}
		if (inputText.length() <= 2) {
			System.out.println("Minimum three characters should be present");
		}
		// ODD Occuring Palindromes
		int len = inputText.length();
		for (int i = 1; i < len - 1; i++) {
			for (int j = i - 1, k = i + 1; j >= 0 && k < len; j--, k++) {
				System.out.println(i + " " + j + ":" + inputText.charAt(j) + " " + k + ":" + inputText.charAt(k));
				if (inputText.charAt(j) == inputText.charAt(k)) {
					System.out.println("Even\t" +inputText.subSequence(j, k + 1));
				} else {
					break;
				}
			}
		}
		System.out.println("\n");
		// EVEN Occuring Palindromes
		for (int i = 1; i < len - 1; i++) {
			for (int j = i, k = i + 1; j >= 0 && k < len; j--, k++) {
				System.out.println(i + " " + j + ":" + inputText.charAt(j) + " " + k + ":" + inputText.charAt(k));
				if (inputText.charAt(j) == inputText.charAt(k)) {
					System.out.println("Odd\t" +inputText.subSequence(j, k + 1));
				} else {
					break;
				}
			}
		}

	}
}