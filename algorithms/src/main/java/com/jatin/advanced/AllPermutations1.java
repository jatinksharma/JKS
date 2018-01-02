package com.jatin.advanced;

public class AllPermutations1 {

	public static void main(String args[]) {
		permuteString("", "ABCD");
	}

	public static void permuteString(String beginningString, String endingString) {
		System.out.println(beginningString + "  - " + endingString);
		if (endingString.length() <= 1){
			System.out.println("Permutation");
			System.out.println(beginningString + endingString);
			System.out.println("\n");
		}else
		{
			System.out.println("Ending string? " + endingString);
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i)	+ endingString.substring(i + 1);

					permuteString(beginningString + endingString.charAt(i),	newString);
				
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

}
