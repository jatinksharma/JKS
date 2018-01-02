package com.jatin.basic.sort;

import java.util.Random;

public class QuickSort {
	// Usage: java QuickSort [integer] ...
	// All integers must be distinct
	public static void main(String argv[]) {
		int arr[] = new int[10];
		
		Random r = new Random();
		for(int i=0; i<10; i++){
			arr[i] = r.nextInt(100);
		}

		print(arr);
		
		quickSort(arr, 0, arr.length - 1);

		print(arr);
		
	}

	public static void print(int[] arr){
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
	static int partition(int arr[], int left, int right)
	{	
		
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      System.out.println("\n");
	      System.out.println(pivot);
			print(arr);
			System.out.println("\n");
	      
	      return i;
	}
	 
	static void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}

}