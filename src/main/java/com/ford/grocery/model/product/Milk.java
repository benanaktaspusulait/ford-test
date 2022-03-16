package com.ford.grocery.model.product;

import com.ford.grocery.constant.Constants;
import com.ford.grocery.model.enums.ProductType;
import com.ford.grocery.model.enums.ProductUnit;
import com.ford.grocery.model.product.base.BaseProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Milk extends BaseProduct {

    public Milk() {
        setProductType(ProductType.MILK);
        setProductUnit(ProductUnit.BOTTLE);
        setPrice(Constants.MILK_PRICE);
    }

}