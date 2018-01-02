package com.jatin.recursion;

public class Permutation {
	public static void main(String[] args) {
		permutate("ABCD".toCharArray(), 0);
	}
	
	static void permutate( char[] str, int index )
	{
	    int i = 0;
	    if( index == str.length )
	    { // We have a permutation so print it
	        System.out.println(str);
	        return;
	    }
	    for( i = index; i < str.length; i++ )
	    {
	        swap( str, index, i ); // It doesn't matter how you swap.
	        permutate( str, index + 1 );
	        swap( str, index, i );
	    }
	}
	
	static void swap(char[] str, int index, int i){
		char a = str[index];
		str[index] = str[i];
		str[i] = a;
	}
	
	
}
