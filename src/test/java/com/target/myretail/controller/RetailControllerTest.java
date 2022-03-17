package com.target.myretail.controller;

import com.target.myretail.model.myretail.CurrentPrice;
import com.target.myretail.model.myretail.RetailResponse;
import com.target.myretail.service.RetailService;

import com.target.myretail.utils.RetailUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class RetailControllerTest {

    @Mock
    RetailService productService;

    @InjectMocks
    RetailController retailController;

    @Mock
    RetailUtils retailUtils;

    @Test
    public void testGetRetailInfo(){
        RetailResponse retailResponse= new RetailResponse();
        retailResponse.setName("target");
        CurrentPrice currentPrice = new CurrentPrice();
        currentPrice.setValue(90.00);
        currentPrice.setCurrency_code("USD");
        retailResponse.setCurrent_price(currentPrice);
        Mockito.when(retailUtils.validateProductId("54456119", retailResponse)).thenReturn(false);
        Mockito.when(productService.getRetailResponse("54456119", retailResponse)).thenReturn(retailResponse);
        retailController.getRetailInfo("54456119");
    }

    @Test
    public void testGetRetailInfo_success(){
        assertNotNull(retailController.getRetailInfo("54456119"));
    }
}