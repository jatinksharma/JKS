package com.jatin.basic;

public class FinAllSubSets1 {
	public static void main(String[] args) {
		susbsets(3);
	}
	
	public static void susbsets(Integer N){
		int allMasks = (1 << N);
		for (int i = 1; i < allMasks; i++)
		{
		    for (int j = 0; j < N; j++)
		        if ((i & (1 << j)) > 0) //The j-th element is used
		           System.out.print((j + 1) + " ");

		    System.out.println();
		}
	}
}
