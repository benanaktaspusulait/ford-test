package com.ford.grocery.model.product.base;

import com.ford.grocery.model.enums.ProductType;
import com.ford.grocery.model.enums.ProductUnit;
import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class BaseProduct {

    private Long id;
    private String name;
    private ProductType productType;
    private BigDecimal price;
    private ProductUnit productUnit;
}