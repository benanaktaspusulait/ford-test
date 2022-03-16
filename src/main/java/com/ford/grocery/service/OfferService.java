package com.ford.grocery.service;


import com.ford.grocery.model.Offer;
import com.ford.grocery.model.enums.ProductType;
import com.ford.grocery.predicate.OfferPredicate;

import java.util.Date;
import java.util.List;

public class OfferService {

    public static Offer findOffer(List<Offer> offerList, ProductType productType, Date date) {

        return offerList.stream()
                .filter(OfferPredicate.filterByDate(date))
                .filter(OfferPredicate.filterByProductType(productType))
                .findAny()
                .orElse(null);
    }
}