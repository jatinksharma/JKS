package com.jatin.deisgnpatterns.decorator;

public class SimpleCoffee extends AbstractCoffee {
	public double getCost() {
		return 1;
	}

	public String getIngredients() {
		return "Coffee";
	}
}