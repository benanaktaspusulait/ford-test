package com.ford.grocery.dataseeder;

import com.ford.grocery.model.Offer;
import com.ford.grocery.model.enums.ProductType;
import com.ford.grocery.util.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is to generate offers
 */
public class OfferSeeder {
    public static List<Offer> createOffers() {

        List<Offer> offerList = new ArrayList<>();

        Offer appleOffer = new Offer();
        appleOffer.setId(1L);
        appleOffer.setName("appleOffer");
        appleOffer.setDescription("Apples 10% off: ");
        appleOffer.setOfferFunction("function appleOffer(x) { return  x.applesCount * ((x.applesPrice * 10)/100);}");
        appleOffer.setProductType(ProductType.APPLES);
        appleOffer.setValidStartDate(DateUtils.daysAfter(3));
        appleOffer.setValidEndDate(DateUtils.getEndOfMonth());

        offerList.add(appleOffer);

        Offer breadOffer = new Offer();
        breadOffer.setId(2L);
        breadOffer.setName("breadOffer");
        breadOffer.setDescription("Bread half price: ");
        breadOffer.setOfferFunction("function breadOffer(x) {if (x.soupCount >= 2){ return  Math.floor(x.soupCount / 2 ) * (x.breadPrice / 2);} return 0;}");
        breadOffer.setProductType(ProductType.BREAD);
        breadOffer.setValidStartDate(DateUtils.daysAfter(-1));
        breadOffer.setValidEndDate(DateUtils.daysAfter(-1 + 7));
        offerList.add(breadOffer);

        return offerList;
    }
}
