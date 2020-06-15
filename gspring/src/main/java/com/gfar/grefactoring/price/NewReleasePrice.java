package com.gfar.grefactoring.price;

import com.gfar.grefactoring.entity.Movie;

public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getCharge(int dayRented){
        return dayRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented){
        return (daysRented > 1) ? 2: 1;
    }
}
