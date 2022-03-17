package com.target.myretail.client;


import com.target.myretail.common.RetailConstants;
import com.target.myretail.error.ApiError;
import com.target.myretail.model.product.ProductResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ProductInfoClient {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${target.redsky.endpoint}")
    String redSkyEndpoint;

    public ProductResponse getProductName(@NonNull String productId){
        ProductResponse  productResponse = new ProductResponse();
        try {
            //validating final URL
            String redSkyUrl = redSkyEndpoint.replace("{productid}", productId);
            if (StringUtils.isNotBlank(redSkyUrl)) {
                productResponse = restTemplate.getForObject(redSkyUrl, ProductResponse.class);
            }
            //validating response
            if (productResponse == null && productResponse.getData() == null) {
                    String message = "Product Data is empty from the RedSky service";
                    log.info(message);
            }else{
                log.info("product response is success for product id - {}", productId);
            }
        }catch (HttpServerErrorException | HttpClientErrorException e) {
            log.error("Http Client or Http Server Exception - Product RedSky Service failed for productId - {}", productId);
            if (e.getRawStatusCode() == 404) {
                String message = "No Product data found fo for productId - {}" + productId;
                productResponse.setApiError(new ApiError(RetailConstants.NOT_FOUND_ERROR, RetailConstants.NOT_FOUND, message));
            } else {
                String message = "Http Client or Http Server Exception - Product RedSky Service failed for productId - {}" + productId;
                productResponse.setApiError(new ApiError(RetailConstants.INTERNAL_SERVER_ERROR_CODE, RetailConstants.INTERNAL_SERVER_ERROR, message));
            }
        }
        return productResponse;
    }

}
