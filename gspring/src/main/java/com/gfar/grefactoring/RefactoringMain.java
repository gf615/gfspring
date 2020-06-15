package com.gfar.grefactoring;

import com.gfar.grefactoring.entity.Customer;
import com.gfar.grefactoring.entity.Movie;
import com.gfar.grefactoring.entity.Rental;

public class RefactoringMain {
    public static void main(String[] args) {
        Movie movie1 = new Movie("杀破狼",Movie.REGULAR);
        Movie movie2 = new Movie("仙剑奇侠传",Movie.CHILDRENS);
        Movie movie3 = new Movie("倩女幽魂",Movie.NEW_RELEASE);

        Rental rental1 = new Rental(movie1,3);
        Rental rental2 = new Rental(movie2,5);
        Rental rental3 = new Rental(movie3,10);

        Customer customer = new Customer("烧包");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        String result = customer.statement();
        System.out.println(result);
        System.out.println(customer.htmlStatement());
    }
}
