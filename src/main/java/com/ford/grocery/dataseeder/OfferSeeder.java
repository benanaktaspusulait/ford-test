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

        Offer appleOffer = Offer.builder()
                .name("appleOffer")
                .description("Apples 10% off: ")
                .offerFunction("function appleOffer(x) { return  x.applesCount * ((x.applesPrice * 10)/100);}")
                .productType(ProductType.APPLES)
                .validStartDate((DateUtils.daysAfter(3)))
                .validEndDate(DateUtils.getEndOfMonth()).build();

        offerList.add(appleOffer);

        Offer breadOffer = Offer.builder()
                .name("breadOffer")
                .description("Bread half price: ")
                .offerFunction("function breadOffer(x) {if (x.soupCount >= 2){ return  Math.floor(x.soupCount / 2 ) * (x.breadPrice / 2);} return 0;}")
                .productType(ProductType.BREAD).validStartDate(DateUtils.daysAfter(-1))
                .validEndDate(DateUtils.daysAfter(-1 + 7)).build();
        offerList.add(breadOffer);

        return offerList;
    }
}
