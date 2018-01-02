package com.jatin.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* Given a list of integers, sort all odd position ints and put them 
 * in first half, and sort all even position ints and put them in second half, 
 * do it in place.
 * 
 */

public class EvenFrontOddBack {
	static int[] arr = new int[10];
	
	public static void main(String[] args) {
		
		for(int i = 0; i< 10 ; i++){
			Random r = new Random();
			arr[i] = r.nextInt(100);
		}
		
		printList();
		
		System.out.println("\n");
		
		swapEvenOdd();
		
		System.out.println("\n");
		
		printList();
		
		sortEvenOdd();
		
		System.out.println("\n");
		
		printList();

		
		
		
	}
	
	static void swapEvenOdd(){
		if(arr.length %2 == 0){
			for(int i=0, j= arr.length-1; i<arr.length/2; i = i+2, j=j-2){
				if(i%2 ==0){
					swap(i, j);
				}
			}
		}else{
			for(int i=1, j= arr.length-1; i<arr.length/2; i = i+2, j=j-2){
				if(i%2 ==0){
					swap(i, j);
					System.out.println("\n" + i + " , " + j + "\n");
				}
			}
		}
		
	}
	
	static void swap(int i, int j) {
		int a = arr[i];
		arr[i] = arr[j];
		arr[j] = a;
	}

	static void sortEvenOdd(){
	
		
		Arrays.sort(arr, 0, arr.length/2-1);
		
		Arrays.sort(arr, arr.length/2 , arr.length);
	}
	

	
	static void printList(){
		for(int i = 0 ; i< arr.length ; i++){
			System.out.print(" "+arr[i]);
		}
	}
}
