package com.astonengineers.version1.model;



import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "PRODUCT")
/*
  This is the product model class and describes a what a product is
 */
public class Product {

    /**
     *
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer ID;
    private String productName;
    private String productDescription;
    private String productPrice;
    private int productQuantity;
    private String productCategory;
    private String productImg;
    
}
