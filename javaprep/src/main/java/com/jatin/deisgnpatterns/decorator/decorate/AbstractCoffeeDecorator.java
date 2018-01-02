package com.jatin.deisgnpatterns.decorator.decorate;

import com.java.concurrency.iterRecur.deisgnpatterns.decorator.AbstractCoffee;

public abstract class AbstractCoffeeDecorator extends AbstractCoffee {
	protected final AbstractCoffee decoratedCoffee;
	protected String ingredientSeparator = ", ";

	public AbstractCoffeeDecorator(AbstractCoffee decoratedCoffee) {
		this.decoratedCoffee = decoratedCoffee;
	}

	public double getCost() { // implementing methods of the abstract class
		return decoratedCoffee.getCost();
	}

	public String getIngredients() {
		return decoratedCoffee.getIngredients();
	}
}
