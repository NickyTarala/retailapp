package com.target.myretail.model.mongodb.pricecluster;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("price")
@Data
public class Price {

    @Id
    private String id;

    private String productId;

    private String currencyCode;

    private String price;

    private String countryCode;

    public Price(String id, String productId, String currencyCode, String price, String countryCode) {
        this.id = id;
        this.productId = productId;
        this.currencyCode = currencyCode;
        this.price = price;
        this.countryCode = countryCode;
    }
}
