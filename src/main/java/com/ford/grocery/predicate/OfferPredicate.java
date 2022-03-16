package com.ford.grocery.predicate;

import com.ford.grocery.model.Offer;
import com.ford.grocery.model.enums.ProductType;

import java.util.Date;
import java.util.function.Predicate;

public class OfferPredicate {

    public static Predicate<Offer> filterByDate(Date date) {
        return pr -> (pr.getValidStartDate().before(date) &&
                pr.getValidEndDate().after(date));
    }

    public static Predicate<Offer> filterByProductType(ProductType productType) {
        return pr -> (pr.getProductType().equals(productType));
    }

}