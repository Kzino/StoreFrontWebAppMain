package com.astonengineers.version1.service;

import com.astonengineers.version1.controller.ProductAddRequest;
import com.astonengineers.version1.controller.ProductResponse;
import com.astonengineers.version1.controller.ProductUpdateRequest;
import com.astonengineers.version1.model.Product;
import com.astonengineers.version1.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    public void setUpService() {
        //productRepository = mock(ProductRepository.class);
        //productService = new ProductService(productRepository);

        product = Product.builder()
                .ID(1)
                .productName("Version 1 Bag")
                .productDescription("Kwame Version 1 Bag")
                .productPrice("£10")
                .productQuantity(10)
                .productCategory("Accessories")
                .productImg("Version1Bag.png")
                .build();

    }

    @Test
    void getAllProducts() {
        // given = precondition or setup
        Product product1 = Product.builder()
                .ID(2)
                .productName("Version 1 Bottle")
                .productDescription("Kwame Version 1 Bottle")
                .productPrice("£5")
                .productQuantity(5)
                .productCategory("Accessories")
                .productImg("Version1Bottle.png")
                .build();

        given(productRepository.findAll()).willReturn(List.of(product, product1));

        // when - action or the behaviour that we are going to test
        List<ProductResponse> productList = productService.getAllProducts();

        // then - verify output
        assertThat(productList).isNotNull();
        assertThat(productList.size()).isEqualTo(2);
    }

    @Test
    public void findById() {

    }

    @Test
    void updateProduct() {
        // given - precondition or setup
        given(productRepository.save(product)).willReturn(product);
        product.setProductName("Version 1 Bag");
        product.setProductDescription("Kwames Version 1 Bag");
        product.setProductPrice("£10");
        product.setProductQuantity(7);
        product.setProductCategory("Accessories");
        product.setProductImg("Version1Bag.png");

        // when - action or the behavior that we are going test
        ProductUpdateRequest productUpdateRequest = getProductUpdateRequest();

        // then - verify the output
        assertThat(productUpdateRequest.getProductName()).isEqualTo("Version 1 Bag");
        assertThat(productUpdateRequest.getProductDescription()).isEqualTo("Kwames Version 1 Bag");
        assertThat(productUpdateRequest.getProductPrice()).isEqualTo("£10");
        assertThat(productUpdateRequest.getProductQuantity()).isEqualTo(7);
        assertThat(productUpdateRequest.getProductCategory()).isEqualTo("Accessories");
        assertThat(productUpdateRequest.getProductImg()).isEqualTo("Version1Bag.png");
    }

    @Test
    void addProduct() {
    // given  - precondition or setup


    // when - action or the behaviour that we are going to test

    // verify - verify the output
    }

    @Test
    public void deleteProduct() {
        // given - precondition or setup
        Integer productId = 1;
        willDoNothing().given(productRepository).deleteById(productId);

        // when - action or the behaviour that were going test
        productService.deleteProduct(productId);
        // then - verify the output
        verify(productRepository, times(1)).deleteById(productId);
    }


    private ProductResponse getProductResponse() {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setID(1);
        productResponse.setProductName("Version 1 Bag");
        productResponse.setProductDescription("Kwame's Version 1 Bag");
        productResponse.setProductPrice("£10");
        productResponse.setProductQuantity(5);
        productResponse.setProductCategory("Accessories");
        productResponse.setProductImg("Version1Bag.png");

        return productResponse;
    }

    private ProductAddRequest getProductAddRequest() {
        ProductAddRequest productAddRequest = new ProductAddRequest();
        productAddRequest.setProductName("Version 1 Bottle");
        productAddRequest.setProductDescription("Kwame's Version 1 Bottle");
        productAddRequest.setProductPrice("£5");
        productAddRequest.setProductQuantity(10);
        productAddRequest.setProductCategory("Accessories");
        productAddRequest.setProductImg("Version1Bottle.png");
        return productAddRequest;
    }

    private ProductUpdateRequest getProductUpdateRequest() {
        ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest();
        productUpdateRequest.setProductName("Version 1 Bottle");
        productUpdateRequest.setProductDescription("Version 1 Bottle Updated!");
        productUpdateRequest.setProductPrice("10");
        productUpdateRequest.setProductQuantity(5);
        productUpdateRequest.setProductCategory("Accessories");
        productUpdateRequest.setProductImg("Version1Bottle.png");
        return productUpdateRequest;
    }

    @Test
    void toResponse() {

    }
}