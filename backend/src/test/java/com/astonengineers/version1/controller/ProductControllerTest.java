package com.astonengineers.version1.controller;

import com.astonengineers.version1.AstonengineersApplication;
import com.astonengineers.version1.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 *  This class tests the API endpoints using Mockito and Junit.
 */

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.properties"})
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private ProductController productController;

    @Test
     void getAllProducts() throws Exception {
        ProductResponse productResponse = getProductResponse();
        List<ProductResponse> productList = new ArrayList<>();
        productList.add(productResponse);
        given(productController.getAllProducts()).willReturn(productList);

        mvc.perform(get("/list")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(asJson(productList),false))
                .andReturn();


    }

    @Test
    public void viewProduct() throws  Exception {
        ProductResponse productResponse = getProductResponse();
        given(productController.viewProduct(1)).willReturn(productResponse);
        mvc.perform(get("/view?id=1").content(asJson(productResponse)).contentType(APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void addProduct() throws  Exception {
        ProductResponse productResponse = getProductResponse();
        ProductAddRequest productAddRequest = getProductAddRequest();
        given(productController.addProduct(productAddRequest)).willReturn(productResponse);
        mvc.perform(post("/add").content(asJson(productResponse)).contentType(APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void updateProduct() throws Exception {
        ProductResponse productResponse = getProductResponse();
        ProductUpdateRequest productUpdateRequest = getProductUpdateRequest();
        given(productController.updateProduct(productUpdateRequest)).willReturn(productResponse);
        mvc.perform(patch("/update").content(asJson(productResponse)).contentType(APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void deleteProduct() throws Exception {
         ProductResponse productResponse = getProductResponse();
         doNothing().when(productController).deleteProduct(1);
         mvc.perform(delete("/delete?id=1" + productResponse.getID()).contentType(APPLICATION_JSON))
                 .andExpect(status().isOk()).andReturn();



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

    private static String asJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}