package com.ford.grocery.model.dto;

import com.ford.grocery.model.enums.ProductType;
import com.ford.grocery.model.product.Apples;
import com.ford.grocery.model.product.Bread;
import com.ford.grocery.model.product.Milk;
import com.ford.grocery.model.product.Soup;
import com.ford.grocery.model.product.base.BaseProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class is for generation calculate object
 */
@Data
@Builder
@AllArgsConstructor
public class CalculateDTO {

    private Long applesCount;
    private Long breadCount;
    private Long milkCount;
    private Long soupCount;
    private BigDecimal applesPrice;
    private BigDecimal breadPrice;
    private BigDecimal milkPrice;
    private BigDecimal soupPrice;

    public static CalculateDTO generateDTO(List<BaseProduct> productList) {
        return CalculateDTO.builder()
                .applesCount(getNumberOfProduct(productList, ProductType.APPLES))
                .breadCount(getNumberOfProduct(productList, ProductType.BREAD))
                .milkCount(getNumberOfProduct(productList, ProductType.MILK))
                .soupCount(getNumberOfProduct(productList, ProductType.SOUP))
                .applesPrice(new Apples().getPrice())
                .breadPrice(new Bread().getPrice())
                .milkPrice(new Milk().getPrice())
                .soupPrice(new Soup().getPrice())
                .build();
    }

    public static Long getNumberOfProduct(List<BaseProduct> productList, ProductType productType) {

        return productList.stream()
                .filter((g) -> productType.equals(g.getProductType()))
                .count();
    }

    public static BigDecimal getProductPrice(ProductType productType) {

        BigDecimal price;

        switch (productType) {
            case MILK:
                price = new Milk().getPrice();
                break;
            case APPLES:
                price = new Apples().getPrice();
                break;
            case BREAD:
                price = new Bread().getPrice();
                break;
            case SOUP:
                price = new Soup().getPrice();
                break;
            default:
                price = BigDecimal.ZERO;
        }
        return price;

    }

    public static BaseProduct convertStringToProduct(String productText) {

        if (productText.equalsIgnoreCase("Bread")) {
            return new Bread();
        } else if (productText.equalsIgnoreCase(("Apples"))) {
            return new Apples();
        } else if (productText.equalsIgnoreCase(("Milk"))) {
            return new Milk();
        } else if (productText.equalsIgnoreCase(("Soup"))) {
            return new Soup();
        }
        return null;

    }


}