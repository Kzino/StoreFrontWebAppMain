package com.astonengineers.version1.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class handles the product update request and contains all the
 * relevant fields needed to update a product
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductUpdateRequest {
    private Integer ID;
    private String productName;
    private String productDescription;
    private String productPrice;
    private int productQuantity;
    private String productCategory;
    private String productImg;
}
