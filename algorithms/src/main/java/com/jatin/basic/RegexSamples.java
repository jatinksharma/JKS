package com.jatin.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSamples {
	public static void main(String[] args) {
		validateSSN("300-20-8000");
		validateSSN("300-20-800");
		validateEmail("jatinksharma01@something.com");
		validateEmail("vicky_saini-007.bhuppi@yahoo.co.in");
		validatePhone("(425)306-2503");
		validatePhone("(425) 306-2503");
		
		validateLicensePlate("958RSY");
		validateLicensePlate("9958RSY");
		validateLicensePlate("958RSYZZ");
	}
	
	/*
	 * 1) At most 6 digits long
	 * 2) Must start with a number
	 * 3) Numbers can be from 1-3 in total in the beginning only.
	 * 4) Rest should be alphabets
	 */
	public static void validateLicensePlate(String plateNum){
		System.out.println("\nValidating plateNum");
		String expression = "^[0-9]{1}[0-9]{0,2}[a-zA-z]+$";
		String expression1 = "^.{6}$";
		
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(plateNum);
		
		Pattern pattern1 = Pattern.compile(expression1);
		Matcher matcher1 = pattern1.matcher(plateNum);
		
		System.out.println(matcher.matches());
		System.out.println(matcher1.matches());
	}

	public static void validateSSN(String ssn) {
		System.out.println("\nValidating SSN " + ssn);
		System.out.println(ssn.matches("^\\d{3}[-]\\d{2}[-]\\d{4}$"));
		System.out.println(ssn.matches("[0-9]{3}[-][0-9]{2}[-][0-9]{4}"));
	}

	public static void validateEmail(String email) {
		System.out.println("\nValidating e-mail " + email);
		// start with one or more alphabets
		// can contain numbers but cannot start with number
		// can contain one or more dots
		// can contain one or more hyphens
		// must be followed by one @
		// followed by one or more alphabets
		// must be followed by .
		// must be followed by one or more alphabets
		String expression = "^[a-zA-Z][a-zA-Z0-9\\.\\-_]+[@][a-zA-Z\\.]+[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(email);
		System.out.println(matcher.matches());
		
		expression = "^[\\w^\\d][\\w\\.\\-_]+[@][\\w^\\d\\.]+[\\w^\\d]+$";
		Pattern pattern2 = Pattern.compile(expression);
		Matcher matcher2 = pattern2.matcher(email);
		System.out.println(matcher2.matches());
		
		expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern1 = Pattern.compile(expression);
		Matcher matcher1 = pattern1.matcher(email);
		System.out.println(matcher1.matches());
	}

	public static void validatePhone(String phone) {
		System.out.println("\nValidating phone " + phone);
		// start with parantheses
		// should have 3 nums only
		// closes with parantheses
		// should have zero or one space only
		// should have 3 nums only
		// should have hyphen
		// should have 4 nums only
		System.out.println(phone
				.matches("[\\(][\\d]{3}[\\)][ ]{0,1}[\\d]{3}[\\-][\\d]{4}"));
	}
}
