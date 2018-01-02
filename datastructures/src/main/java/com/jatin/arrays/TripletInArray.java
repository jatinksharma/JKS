package com.jatin.arrays;

public class TripletInArray {
	public static void main(String[] args) {
		int[] arr = new int[10];
		arr[0] = 44;
		arr[1] = 33;
		arr[2] = 22;
		arr[3] = 11;
		arr[4] = 37;
		arr[5] = 20;
		arr[6] = 15;
		arr[7] = 35;
		arr[8] = 16;
		arr[9] = 19;

		printArr(arr);

		System.out.println("\n");

		printArr(findTriplet(arr));
		
		System.out.println("\n");
		
		printArr(findTriplet1(arr));
	}

	static int[] findTriplet(int[] arr) {
		int[] triplet = new int[3];
		int a = 0, b = 0, c = 0;

		boolean found = false;
		for (int i = 0; i < arr.length; i++) {
			if (found) {
				break;
			}
			a = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > a) {
					if (found) {
						break;
					}
					b = arr[j];
					for (int k = j + 1; k < arr.length; k++) {
						if (arr[k] > b) {
							c = arr[k];
							found = true;
							break;
						}
					}
				}

			}
		}

		triplet[0] = a;
		triplet[1] = b;
		triplet[2] = c;

		return triplet;
	}

	static int[] findTriplet1(int[] list){
		int[] triplet = new int[3]; 
		int a;
		a=triplet[0]=list[0];
		triplet[1]=triplet[2]=0;
		for(int i=1;i<list.length;i++){
			if(list[i]<=a){
				a=list[i];
			}else if(list[i]<=triplet[1]){
				triplet[0]=a;
				triplet[1]=list[i];
			}else{
				triplet[2]=list[i];
			}
			break;
		}
		
		return triplet;
	}
	

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}
}
