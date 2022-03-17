package com.target.myretail.model.product;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Product {

    @JsonProperty("tcin")
    private String tcin;

    @JsonProperty("item")
    private Item item;
}
