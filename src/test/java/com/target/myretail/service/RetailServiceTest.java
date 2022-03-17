package com.target.myretail.service;

import com.target.myretail.client.ProductInfoClient;
import com.target.myretail.model.mongodb.pricecluster.Price;
import com.target.myretail.model.myretail.RetailResponse;
import com.target.myretail.model.product.*;
import com.target.myretail.repository.PriceRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class RetailServiceTest {

    @InjectMocks
    RetailService retailService;

    @Mock
    ProductInfoClient productInfoClient;

    @Mock
    PriceRepository priceRepository;

    @Test
    public void test_getRetailResponse(){
        RetailResponse retailResponse= new RetailResponse();
        ProductResponse productResponse = new ProductResponse();
        Data data = new Data();
        Product product = new Product();
        Item item = new Item();
        ProductDescription productDescription = new ProductDescription();
        productDescription.setTitle("Target");
        product.setItem(item);
        data.setProduct(product);
        item.setProductDescription(productDescription);
        productResponse.setData(data);
        Price price = new Price("544561192394","54456119","USD","999","USD");
        Mockito.when(productInfoClient.getProductName("54456119")).thenReturn(productResponse);
        Mockito.when(priceRepository.findByProductId("54456119")).thenReturn(price);

        retailResponse.setName("Target");
        retailService.getRetailResponse("54456119",retailResponse);
        Assert.assertEquals(productResponse.getData().getProduct().getItem().getProductDescription().getTitle(), retailResponse.getName());

    }

    @Test
    public void test_getRetailResponse_whenNameisNull(){
        RetailResponse retailResponse= new RetailResponse();
        ProductResponse productResponse = new ProductResponse();
        Data data = new Data();
        Product product = new Product();
        Item item = new Item();
        ProductDescription productDescription = new ProductDescription();
        productDescription.setTitle(null);
        product.setItem(item);
        data.setProduct(product);
        item.setProductDescription(productDescription);
        productResponse.setData(data);
        Price price = new Price("544561192394","54456119","USD","999","USD");
        Mockito.when(productInfoClient.getProductName("54456119")).thenReturn(productResponse);
        Mockito.when(priceRepository.findByProductId("54456119")).thenReturn(price);

        retailResponse.setName(null);
        retailService.getRetailResponse("54456119",retailResponse);
        Assert.assertEquals(productResponse.getData().getProduct().getItem().getProductDescription().getTitle(), retailResponse.getName());

    }

    @Test
    public void test_getRetailResponse_whenCurrencyisNull(){
        RetailResponse retailResponse= new RetailResponse();
        ProductResponse productResponse = new ProductResponse();
        Data data = new Data();
        Product product = new Product();
        Item item = new Item();
        ProductDescription productDescription = new ProductDescription();
        productDescription.setTitle(null);
        product.setItem(item);
        data.setProduct(product);
        item.setProductDescription(productDescription);
        productResponse.setData(data);
        Price price = new Price("544561192394","54456119",null,"999","USD");
        Mockito.when(productInfoClient.getProductName("54456119")).thenReturn(productResponse);
        Mockito.when(priceRepository.findByProductId("54456119")).thenReturn(price);

        retailResponse.setName(null);
        retailService.getRetailResponse("54456119",retailResponse);
        Assert.assertEquals(productResponse.getData().getProduct().getItem().getProductDescription().getTitle(), retailResponse.getName());

    }

    @Test
    public void test_getRetailResponse_whenPriceisNull(){
        RetailResponse retailResponse= new RetailResponse();
        ProductResponse productResponse = new ProductResponse();
        Data data = new Data();
        Product product = new Product();
        Item item = new Item();
        ProductDescription productDescription = new ProductDescription();
        productDescription.setTitle(null);
        product.setItem(item);
        data.setProduct(product);
        item.setProductDescription(productDescription);
        productResponse.setData(data);
        Price price = new Price("544561192394","54456119","USD",null,"USD");
        Mockito.when(productInfoClient.getProductName("54456119")).thenReturn(productResponse);
        Mockito.when(priceRepository.findByProductId("54456119")).thenReturn(price);

        retailResponse.setName(null);
        retailService.getRetailResponse("54456119",retailResponse);
        Assert.assertEquals(productResponse.getData().getProduct().getItem().getProductDescription().getTitle(), retailResponse.getName());

    }
}