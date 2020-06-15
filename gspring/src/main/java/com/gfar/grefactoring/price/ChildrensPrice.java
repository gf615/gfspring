package com.gfar.grefactoring.price;

import com.gfar.grefactoring.entity.Movie;

public class ChildrensPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    public double getCharge(int dayRented){
        double result = 1.5;
        if (dayRented > 3){
            result += (dayRented - 3) * 1.5;
        }
        return result;
    }

}
