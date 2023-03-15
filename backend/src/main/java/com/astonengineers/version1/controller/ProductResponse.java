package com.astonengineers.version1.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * This class describes a Product Response which consists of the relevant fields
 * It is a DTO which is a type of POJO, essentially objects that transfer data between process
 * in order to reduce the number of method calls
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Integer ID;
    private String productName;
    private String productDescription;
    private String productPrice;
    private int productQuantity;
    private String productCategory;
    private String productImg;
}
