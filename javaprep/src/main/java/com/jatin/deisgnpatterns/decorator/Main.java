package com.jatin.deisgnpatterns.decorator;

import com.java.concurrency.iterRecur.deisgnpatterns.decorator.decorate.Milk;
import com.java.concurrency.iterRecur.deisgnpatterns.decorator.decorate.Whip;

public class Main {
	 public static final void main(String[] args) {
		 	AbstractCoffee c = new SimpleCoffee();
	        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
	 
	        c = new Milk(c);
	        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
	 
	        c = new Whip(c);
	        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
	 
	       
	    }
}
