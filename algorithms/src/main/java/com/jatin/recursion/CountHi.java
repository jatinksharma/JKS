package com.jatin.recursion;


/**
countHi("xxhixx") → 1
countHi("xhixhix") → 2
countHi("hi") → 1
 * @author sharmaj
 *
 */
public class CountHi {
	
	public static void main(String[] args) {
		System.out.println(countHi("HicountHi"));
		System.out.println(countHi("xxHixx"));
		System.out.println(countHi("HicountHi"));
		System.out.println(countHi("HicountHi"));
		System.out.println(countHi("HicountHi"));
	}
	
	static int countHi(String str){
		int count = 0;
		
		if(str.isEmpty()){
			return 0;
		}
		
		int beginIndex = 0;
		boolean found = false;
		
		for(int i =0; i< str.length() ; i++){
			if(i == str.length()-1){
				break;
			}
			if(str.charAt(i) == 'H' && str.charAt(i+1) == 'i'){
				beginIndex = i+2;
				count++;
				found = true;
				break;
			}
		}
		
		if(!found){
			beginIndex++;
		}
		
		return countHi(str.substring(beginIndex)) + count;
		
		
	}
	
	
}
