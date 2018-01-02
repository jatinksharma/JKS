package com.jatin.basic;

import java.util.ArrayList;
import java.util.Collection;

public enum CondimentsEnum {
	MILK(2), WHIP(5), CINNAMON(4), NUTS(15);
	
	int cost;
	
	private CondimentsEnum(int cost) {
		this.cost = cost;
	}
	
	public static void main(String[] args) {
		Collection<CondimentsEnum> enumColl = new ArrayList<CondimentsEnum>();
		
		enumColl.add(CondimentsEnum.CINNAMON);
		enumColl.add(CondimentsEnum.MILK);
		
		for(CondimentsEnum e : enumColl){
			System.out.println(e.cost);
		}
	}
	
	
}
