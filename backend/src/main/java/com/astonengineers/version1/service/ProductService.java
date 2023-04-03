package com.astonengineers.version1.service;

import com.astonengineers.version1.controller.ProductAddRequest;
import com.astonengineers.version1.controller.ProductResponse;
import com.astonengineers.version1.controller.ProductUpdateRequest;
import com.astonengineers.version1.model.Product;
import com.astonengineers.version1.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class represents the Product Service which communicates between the Product Controller
 * and Product Repository
 */
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Retrieves a list of all products
     *
     * @return a list ProductsResponse objects
     */
    public List<ProductResponse> getAllProducts() {
        List<Product> results = productRepository.findAll();
        List<ProductResponse> collect = new ArrayList<>();
        for (Product result : results) {
            ProductResponse productResponse = toResponse(result);
            collect.add(productResponse);
        }
        return collect;
    }

    /**
     * Retrieves a ProductResponse object representing a Product which has the unique identifier
     * the same as that specified.
     *
     * @param id the unique identifier of the Product required
     * @return a ProductResponse object representing a Product with the same unique identifier
     * as that specified
     */
    public ProductResponse findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return toResponse(product.get());   // TODO: 24/03/2023 sort this out
    }

    /**
     * Retrieves a ProductResponse object of the updated product
     *
     * @param productUpdateRequest which is an object of ProductUpdateRequest
     * @return a ProductResponse updated product
     */
    public ProductResponse updateProduct(ProductUpdateRequest productUpdateRequest) {
        Optional<Product> product = productRepository.findById(productUpdateRequest.getID());
        if (product.isPresent()) {
            product.get().setProductName(productUpdateRequest.getProductName());
            product.get().setProductDescription(productUpdateRequest.getProductDescription());
            product.get().setProductPrice(productUpdateRequest.getProductPrice());
            product.get().setProductQuantity(productUpdateRequest.getProductQuantity());
            product.get().setProductCategory(productUpdateRequest.getProductCategory());
            product.get().setProductImg(productUpdateRequest.getProductImg());
            Product updatedproduct = productRepository.save(product.get());
            return toResponse(updatedproduct);
        } 
        return null;
    }

    /**
     * Retrieves a ProductResponse object of the added product
     *
     * @param productAddRequest which is an object of ProductAddRequest
     * @return a ProductResponse  of the added product
     */
    public ProductResponse addProduct(ProductAddRequest productAddRequest) {
        Product product = toProduct(productAddRequest);
        product = productRepository.save(product);
        return toResponse(product);
    }

    /**
     * Retrieves a Product object
     *
     * @param productAddRequest which is an object of ProductAddRequest
     * @return an instance of Product object
     */
    private static Product toProduct(ProductAddRequest productAddRequest) {
        Product product = new Product();
        product.setProductName(productAddRequest.getProductName());
        product.setProductDescription(productAddRequest.getProductDescription());
        product.setProductPrice(productAddRequest.getProductPrice());
        product.setProductQuantity(productAddRequest.getProductQuantity());
        product.setProductCategory(productAddRequest.getProductCategory());
        product.setProductImg(productAddRequest.getProductImg());
        return product;
    }

    /**
     * Checks to see if a product is present by looking up the
     * unique identifier (id) if it is present then it will delete the product id
     * @param id
     * This method checks to see if a product is present, delete the product ID
     */
    public void deleteProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.deleteById(id);
        }
    }

    /**
     * Retrieves a ProductResponse object
     *
     * @return a model of the Product
     */
    public ProductResponse toResponse(Product model) {
        return ProductResponse.builder().ID(model.getID())
        .productName(model.getProductName())
        .productDescription(model.getProductDescription())
        .productPrice(model.getProductPrice())
        .productCategory(model.getProductCategory())
        .productQuantity(model.getProductQuantity())
        .productImg(model.getProductImg())
        .build();
    }


    
}
