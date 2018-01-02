package com.jatin.recursion;

/*
array220([1, 2, 20], 0) → true
array220([3, 30], 0) → true
array220([3], 0) → false
 */
public class Array220 {

	public static void main(String[] args) {
		int[] arr = new int[3];
		
		arr[0] = 2;
		arr[1] = 20;
		arr[2] = 3;
		
		System.out.println(array220(arr, 0));
		
		arr[0] = 2;
		arr[1] = 1;
		arr[2] = 20;
		
		System.out.println(array220(arr, 0));
		
		arr[0] = 3;
		arr[1] = 30;
		
		
		System.out.println(array220(arr, 0));
		
	}
	
	static boolean array220(int[] arr, int index) {
		
		if(arr.length >=2 && index < arr.length){
			int val = arr[index];
			boolean found = false;
			
			for(int i= index+1; i< arr.length ; i++){
				if(arr[i] == (val * 10)){
					found = true;
					return true;
				}
			}
			
			index++;
			
			return array220(arr, index) || found;
			
			
		}else{
			return false;
		}
		
		
		
	}

	
}
