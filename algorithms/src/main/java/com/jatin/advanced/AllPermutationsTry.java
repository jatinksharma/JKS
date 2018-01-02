package com.jatin.advanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class AllPermutationsTry {
	
	static Set<Set<String>> set = new LinkedHashSet<Set<String>>();
	
	public static void main(String[] args) {
		for(Set<String> s: permute("abcd")){
			System.out.println(s);
		}
	}
	
	static Set<Set<String>> permute(String sample){
		if(sample.length() ==1){
			Set<String> setTemp1 = new HashSet<String>(); 
			setTemp1.add(sample);
			System.out.println("add one  " + sample);
			set.add(setTemp1);
			
		}else{
		
			for(int i=0; i< sample.length(); i++){
				String left = sample.substring(i, i+1);
				String right = sample.substring(i+1);
				
//				System.out.println(": Left=>" + left + " Right=>" + right);
				
				permute(left);
				permute(right);
				
				Set<String> setTemp = new HashSet<String>();
				setTemp.add(sample);
				
				System.out.println("add many " + sample);
				
				set.add(setTemp);
				
				
			}
		}
		
		return set;
		
		
		
		
	}
	
	
	
}
