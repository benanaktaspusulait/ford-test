package com.ford.grocery.model.product;

import com.ford.grocery.constant.Constants;
import com.ford.grocery.model.enums.ProductType;
import com.ford.grocery.model.enums.ProductUnit;
import com.ford.grocery.model.product.base.BaseProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Apples extends BaseProduct {

    public Apples() {
        setProductType(ProductType.APPLES);
        setProductUnit(ProductUnit.SINGLE);
        setPrice(Constants.APPLES_PRICE);
    }

}