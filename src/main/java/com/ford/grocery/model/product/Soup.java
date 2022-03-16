package com.ford.grocery.model.product;

import com.ford.grocery.constant.Constants;
import com.ford.grocery.model.enums.ProductType;
import com.ford.grocery.model.enums.ProductUnit;
import com.ford.grocery.model.product.base.BaseProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Soup extends BaseProduct {

    public Soup() {
        setProductType(ProductType.SOUP);
        setProductUnit(ProductUnit.TIN);
        setPrice(Constants.SOUP_PRICE);
    }
}