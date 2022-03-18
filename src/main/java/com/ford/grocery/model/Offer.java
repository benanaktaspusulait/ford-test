package com.ford.grocery.model;

import com.ford.grocery.model.enums.ProductType;
import lombok.*;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Offer {
    private String name;
    private String description;
    private ProductType productType;
    private String offerFunction;
    private Date validStartDate;
    private Date validEndDate;
}
