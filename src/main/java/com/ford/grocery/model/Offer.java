package com.ford.grocery.model;

import com.ford.grocery.model.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Offer {
    private Long id;
    private String name;
    private String description;
    private ProductType productType;
    private String offerFunction;
    private Date validStartDate;
    private Date validEndDate;
}
