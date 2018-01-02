package com.jatin.basic;

public class FindLongestPalindrome {
	public static void main(String[] args) {
		String s = "ABCIDIDDIDIXYZDIXYZBA";
		
		System.out.println(s);
		
		System.out.println(checkPalindrome("IDIDDIDI"));
		
		System.out.println(findLongestPalindrome(s));
	}
	
	static String findLongestPalindrome(String s){
		char[] arr = s.toCharArray();
		
		for(int i =0; i< arr.length ; i++){
			for(int j = arr.length - 1; j >= 0 ; j--){
				if(arr[i] == arr[j]){
					if(checkPalindrome(s.substring(i, j+1))){
						return s.substring(i, j+1);
					}
				}
			}
		}
		
		return "";
	}
	
	static boolean checkPalindrome(String s){
		boolean isPalindrome = false;
		if(s.length() > 2){
			char[] arr = s.toCharArray();
			for(int i =0, j = arr.length - 1; i< arr.length ; i++, j--){
				if(arr[i] != arr[j]){
					isPalindrome = false;
					break;
				}else{
					isPalindrome = true;	
				}
			}
		}
		
		return isPalindrome;
	}
	
	
	
	
}
