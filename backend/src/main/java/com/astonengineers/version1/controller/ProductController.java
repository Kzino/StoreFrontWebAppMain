package com.astonengineers.version1.controller;

import java.util.List;

import com.astonengineers.version1.security.dto.AuthRequest;
import com.astonengineers.version1.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.astonengineers.version1.service.ProductService;

/**
 * Product Controller class acts as an interface
 * between the Product Model class and View (Frontend - React)
 */
@CrossOrigin(origins = "*")
@Controller
@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private JwtService jwtService;

    /**
     * Retrieves a list of all products
     *
     * @return the lists of ProductResponse of all the products
     */
    @GetMapping("/list")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Retrieves a ProductResponse object representing a Product which has a unique identifier
     *
     * @param id
     * @return a product service id
     */
    @GetMapping("/view")
    public ProductResponse viewProduct(@RequestParam Integer id) {
        return productService.findById(id);
    }

    /**
     * Retrieves a ProductResponse object of the added product
     *
     * @param productAddRequest , which is an object of ProductAddRequest
     * @return an added product
     */

    @PostMapping(path = "add",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse addProduct(@RequestBody ProductAddRequest productAddRequest) {
        return productService.addProduct(productAddRequest);
    }

    /**
     * Retrieves a ProductResponse object of the updated product
     *
     * @param productUpdateRequest
     * @return the updated product
     */
    @PatchMapping(path = "update",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest) {
        return productService.updateProduct(productUpdateRequest);
    }

    /**
     * Deletes the product unique identifier (id)
     *
     * @param id,
     * @return
     */
    @DeleteMapping(path = "delete")
    public void deleteProduct(@RequestParam(required = true) Integer id) {
        productService.deleteProduct(id);

    }

//    @PostMapping(path = "/authenticate")
//    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//        return jwtService.generateToken(authRequest.getUserName());
//    }

    
}
