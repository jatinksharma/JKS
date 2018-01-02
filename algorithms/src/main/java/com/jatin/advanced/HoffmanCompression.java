package com.jatin.advanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class HoffmanCompression {
	
	public static void main(String[] args){
//		convertString("AAAABBBBBCCCCCDDEEFFFFFF");
		count("AAAABBBBBCCCCCDDEEFFFFFF");
	}
	
	static void count(String s){
		
		if(s != null && !s.isEmpty()){
			char[] arr = s.toCharArray();
			
			char count = '1';
		
			for(int i=0 ; i < arr.length; i++){
				
				if(i == arr.length-1){
					arr[i] = count;
					break;
				}
				
				// iterate and count find same chars till you find a different character.
				if( arr[i] != arr[i+1] && !Character.isDigit(arr[i])){

					arr = refreshArrWithNewString(arr, arr[i], i, count);
					
					
					count = '1';
					
				}
				
				count++;
				
			}
		}
		
	}
	
	static char[] refreshArrWithNewString(char[] arr, char a, int pos, int count){
		int beginIndex = 0;
		
		for(int i=0 ; i< arr.length ; i++){
			if(arr[i] == a){
				beginIndex = i;
				break;
			}
		}
	
		String s = ((Arrays.toString(arr)).replaceAll(",", "")).replace("[","").replace("]","");
		
		String s1 = s.substring(0,beginIndex+1);
		String s2 = s.substring(beginIndex, pos+1);
		String s3 = s.substring(pos+1);
		
		s2.replaceAll(Character.toString(a), "");
		
		return (s1+Character.toString(a)+count+s3).toCharArray();
		
	}
	
	static void convertString(String s){
		if(s != null && !s.isEmpty()){
			char[] arr = s.toCharArray();
			
			char count = '1';
			int beginIndex = 0;
			
			for(int i=0 ; i < arr.length; i++){
				
				if(i == arr.length-1){
					arr[i] = count;
					break;
				}
					
				
				// iterate and count find same chars till you find a different character.
				if( arr[i] != arr[i+1]){
					arr[i] = count;
					count = '1';
//					beginIndex = arr[i]
				}
				
				count++;
				
			}
			
			
			Set<Character> set = new LinkedHashSet<Character>();
			for(int j =0; j< arr.length; j++){
				System.out.print(arr[j]);
				set.add(arr[j]);
			}
			
			System.out.println("\n");
			
			for(Character c: set){
				System.out.print(c);
			}
		
		
		}
		
		
	
	
	}
	
}
