package com.ford.grocery.service;

import com.ford.grocery.constant.Constants;
import com.ford.grocery.dataseeder.OfferSeeder;
import com.ford.grocery.model.Offer;
import com.ford.grocery.model.dto.CalculateDTO;
import com.ford.grocery.model.enums.ProductType;
import com.ford.grocery.model.product.base.BaseProduct;
import com.ford.grocery.util.DateUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CalculateService {

    public static String calculate(CalculateDTO dto, List<BaseProduct> productList, Integer day) throws ScriptException, NoSuchMethodException {

        BigDecimal totalAmount = BigDecimal.ZERO;
        BigDecimal totalDiscountAmount = BigDecimal.ZERO;
        List<Offer> offerList = OfferSeeder.createOffers();
        StringBuilder totalText = new StringBuilder();
        Date date = DateUtils.daysAfter(day);
        for (ProductType productType : ProductType.values()) {

            long numberOfProduct = CalculateDTO.getNumberOfProduct(productList, productType);
            Offer offer = OfferService.findOffer(offerList, productType, date);
            BigDecimal discountAmount;
            if (offer != null && numberOfProduct > 0) {
                ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
                Invocable invocable = (Invocable) nashorn;
                nashorn.eval(offer.getOfferFunction());
                discountAmount = new BigDecimal(invocable.invokeFunction(offer.getName(), dto).toString()).
                        setScale(Constants.SCALE, RoundingMode.CEILING);
                if (discountAmount.compareTo(BigDecimal.ZERO) > 0) {
                    totalDiscountAmount = totalDiscountAmount.add(discountAmount);
                }
            }
            totalAmount = totalAmount.add(CalculateDTO.getProductPrice(productType).multiply(new BigDecimal(numberOfProduct)));
        }
        totalAmount = totalAmount.subtract(totalDiscountAmount);
        totalText.append("Expected total cost = ").append(totalAmount).append(";");

        return totalText.toString();
    }

    public static String calculate(String offerLine) throws ScriptException, NoSuchMethodException {
        String[] productArray = offerLine.split(" ");

        List<BaseProduct> productList = new ArrayList<>();
        List<String> productListText = Arrays.asList(productArray);

        int day = Integer.parseInt(productListText.get(productListText.size() - 1));

        productListText.subList(0, productListText.size() - 1).forEach(g -> productList.add(CalculateDTO.convertStringToProduct(g)));

        return CalculateService.calculate(CalculateDTO.generateDTO(productList), productList, day);
    }
}
