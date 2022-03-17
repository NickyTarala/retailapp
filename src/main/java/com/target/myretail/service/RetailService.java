package com.target.myretail.service;

import com.target.myretail.client.ProductInfoClient;
import com.target.myretail.model.mongodb.pricecluster.Price;
import com.target.myretail.model.myretail.CurrentPrice;
import com.target.myretail.model.myretail.RetailResponse;
import com.target.myretail.model.product.ProductResponse;
import com.target.myretail.repository.PriceRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetailService {

    @Autowired
    ProductInfoClient productInfoClient;

    @Autowired
    PriceRepository priceRepository;

    /**
     * fetch retail response from product and price calls
     * @param productId
     * @param retailResponse
     * @return
     */
    public RetailResponse getRetailResponse(@NonNull String productId, RetailResponse retailResponse) {
        //call to fetch product name from redsky service
        ProductResponse productResponse = productInfoClient.getProductName(productId);
        //validate name and set name from product response
        mapProductToRetailResponse(productResponse, retailResponse, productId);
        // fetch price information from price mongodb cloud
        Price price = priceRepository.findByProductId(productId);
        //validate price data to map to retail response
        validatePriceToRetailResponse(price, retailResponse);

        return retailResponse;
    }

    /**
     * validate and map response from product response to retail response
     * @param productResponse
     * @param retailResponse
     * @param productId
     */
    private void mapProductToRetailResponse(ProductResponse productResponse, RetailResponse retailResponse, @NonNull String productId) {
        if (productResponse.getData().getProduct() != null && productResponse.getData().getProduct().getItem() != null
                && productResponse.getData().getProduct().getItem().getProductDescription() != null
                && StringUtils.isNotBlank(productResponse.getData().getProduct().getItem().getProductDescription().getTitle())) {
            //if title not null, set title to name of retail response
            String productName = productResponse.getData().getProduct().getItem().getProductDescription().getTitle();
            log.info("Product Name from Product response - {}", productName);
            retailResponse.setId(productId);
            retailResponse.setName(productName);
        } else {
            //if name is null or empty, set null for name
            retailResponse.setName(null);
        }
    }

    /**
     * validate price response and map to retail response
     * @param price
     * @param retailResponse
     */
    private void validatePriceToRetailResponse(Price price, RetailResponse retailResponse) {
        if (price != null) {
            log.info("price response is success after the mongo db call");
            CurrentPrice currentPrice = new CurrentPrice();
            if (StringUtils.isNotBlank(price.getCurrencyCode())) {
                currentPrice.setCurrency_code(price.getCurrencyCode());
            } else {
                currentPrice.setCurrency_code(null);

            }
            if (StringUtils.isNotBlank(price.getPrice())) {
                currentPrice.setValue(Math.round(Double.valueOf(price.getPrice())*100.0)/100.0);
            } else {
                currentPrice.setValue(0.0);
            }
            retailResponse.setCurrent_price(currentPrice);
        }
    }
}
