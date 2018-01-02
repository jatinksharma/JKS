package com.jatin.currRound;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrRounding {
	
	public static void main(String[] args) {
		BigDecimal one = new BigDecimal(10.09);
		BigDecimal three = new BigDecimal(27.94);
		
		BigDecimal result = one.divide(three, 5, RoundingMode.HALF_UP);
		
		System.out.println(result);
		System.out.println(result.floatValue());
		
		
		
		
	}

	
	
	
	
	
	
	
	
}
