package com.target.myretail.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@lombok.Data
public class Data {

    @JsonProperty("product")
    private Product product;
}
