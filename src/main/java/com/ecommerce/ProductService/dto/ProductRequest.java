package com.ecommerce.ProductService.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String productNo;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
//    private String ProductImage;
//    private String productCategory;

}
