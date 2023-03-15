package com.astonengineers.version1.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a request from the user to add a product, containing all relevant fields.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductAddRequest {
    private String productName;
    private String productDescription;
    private String productPrice;
    private int productQuantity;
    private String productCategory;
    private String productImg;
}
