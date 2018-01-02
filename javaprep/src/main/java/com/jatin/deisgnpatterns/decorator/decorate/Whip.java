package com.jatin.deisgnpatterns.decorator.decorate;

import com.java.concurrency.iterRecur.deisgnpatterns.decorator.AbstractCoffee;

public class Whip extends AbstractCoffeeDecorator {
    public Whip(AbstractCoffee decoratedCoffee) {
        super(decoratedCoffee);
    }
 
    public double getCost() {
        return super.getCost() + 0.7;
    }
 
    public String getIngredients() {
        return super.getIngredients() + ingredientSeparator + "Whip";
    }
}