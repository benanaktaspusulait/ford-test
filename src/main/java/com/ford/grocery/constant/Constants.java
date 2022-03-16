package com.ford.grocery.constant;

import java.math.BigDecimal;

/**
 * this class is constants in the project. we may put these parameters in a properties or yaml file too
 */
public class Constants {

    // product prices
    public final static BigDecimal SOUP_PRICE = new BigDecimal("0.65");
    public final static BigDecimal BREAD_PRICE = new BigDecimal("0.80");
    public final static BigDecimal MILK_PRICE = new BigDecimal("1.30");
    public final static BigDecimal APPLES_PRICE = new BigDecimal("0.10");

    // rounding
    public static final Integer SCALE = 2;
}
