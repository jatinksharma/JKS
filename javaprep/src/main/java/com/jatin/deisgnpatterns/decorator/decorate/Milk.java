package com.jatin.deisgnpatterns.decorator.decorate;

import com.java.concurrency.iterRecur.deisgnpatterns.decorator.AbstractCoffee;

public class Milk extends AbstractCoffeeDecorator {
    public Milk(AbstractCoffee decoratedCoffee) {
        super(decoratedCoffee);
    }
 
    public double getCost() { // overriding methods defined in the abstract superclass
        return super.getCost() + 0.5;
    }
 
    public String getIngredients() {
        return super.getIngredients() + ingredientSeparator + "Milk";
    }
}