package com.gfar.grefactoring.price;

public abstract class Price {
    abstract int getPriceCode();
    public abstract double getCharge(int dayRented);
    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
