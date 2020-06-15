package com.gfar.grefactoring.entity;

import com.gfar.grefactoring.price.ChildrensPrice;
import com.gfar.grefactoring.price.NewReleasePrice;
import com.gfar.grefactoring.price.Price;
import com.gfar.grefactoring.price.RegularPrice;

/**
 * 1.getCharge为什么不自己实现，而要price及其子类实现。只有movie的计算价格方式和租赁积分有变化，影片没有变化。
 * 2.movie 采用多态，实例化子类的时候，顺便创建price实现类对象。
 * 3.好处：解耦、比较容易扩展
 */
public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE =1;
    public static final int CHILDRENS =2;

    private String _title;
    private Price _price;

    public Movie(String title,int priceCode){
        _title = title;
        setPriceCode(priceCode);
    }

    public double getCharge(int dayRented){
        return _price.getCharge(dayRented);
    }

    public int getFrequentRenterPoints(int daysRented){
        return _price.getFrequentRenterPoints(daysRented);
    }

    public String getTitle() {
        return _title;
    }

    //这个函数称为扩展难点，当有新的片类型时，需要修改此处代码。耦合性比较紧，扩展性差；
    //可以对movie也采用多态，每个子类创建的时候设置自己的priceCode对象并创建自己的price对象
    public void setPriceCode(int arg) {
        switch (arg){
            case REGULAR :
                _price = new RegularPrice();
                break;
            case CHILDRENS :
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE :
                _price = new NewReleasePrice();
                break;
            default:
                throw  new IllegalArgumentException("incorrect price code");
        }
    }
}
