package com.jatin.recursion;

/*
 stringClean("yyzzza") → "yza"
 stringClean("abbbcdd") → "abcd"
 stringClean("Hello") → "Helo"
 */
public class StringClean {
	public static void main(String[] args) {
		System.out.println(stringClean("yyzzza"));
		System.out.println(stringCleanHuffman("yyzzza"));
		System.out.println(stringClean("abbbcdd"));
		System.out.println(stringClean("Hello"));
		
		System.out.println(clean("DDDFFGGHHH"));
	}

	static String clean(String s) {

		if (s.isEmpty()) {
			return s;
		}

		int index = 0;
		int count = 1;

		for (int i = 0; i < s.length(); i++) {
			if(i+1 != s.length()){
				if(s.charAt(i) == s.charAt(i+1)){
					count++;
					index++;
				}else{
					break;
				}
			}
			
		}
		
		return "" + s.charAt(index) + count + clean(s.substring(index+1));

	}
	
	
	
	
	
	
	
	
	

	static String stringCleanHuffman(String s) {
		int count = 1;
		if (s.isEmpty()) {
			return "";
		}

		if (s.length() == 1) {
			return s + "" + count;
		}

		char temp = 0;
		int tempIndex = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				temp = s.charAt(i);
				tempIndex = i + 1;
				count++;
			} else {
				temp = s.charAt(i);
				tempIndex = i + 1;
				break;
			}
		}

		return temp + "" + count + stringCleanHuffman(s.substring(tempIndex));

	}

	static String stringClean(String s) {
		if (s.isEmpty()) {
			return "";
		}

		if (s.length() == 1) {
			return s;
		}

		char temp = 0;
		int tempIndex = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				temp = s.charAt(i);
				tempIndex = i + 1;
			} else {
				temp = s.charAt(i);
				tempIndex = i + 1;
				break;
			}
		}

		return temp + stringClean(s.substring(tempIndex));

	}

}
