package com.target.myretail.controller;

import com.target.myretail.model.myretail.RetailResponse;
import com.target.myretail.utils.RetailUtils;
import com.target.myretail.service.RetailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RetailController {

    @Autowired
    RetailService productService;

    @Autowired
    RetailUtils utils;

    @ApiOperation(value = "healthcheck", nickname = "healthcheck")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "myRetail API returns product information",
                    response = String.class, responseContainer = "String") })
    @GetMapping(value = "/target/api/products",  produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value = "/target/api/products",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetailResponse> getRetailInfo(@RequestParam String productId) {
        RetailResponse retailResponse = new RetailResponse();
        log.info("RetailController - calling getRetailInfo API");

        if(!utils.validateProductId(productId, retailResponse)){
            return new ResponseEntity<>(retailResponse, HttpStatus.NOT_FOUND);
        }
        log.info("ProductController - calling database API");

        productService.getRetailResponse(productId, retailResponse);
        return new ResponseEntity<>(retailResponse, HttpStatus.OK);

    }
}