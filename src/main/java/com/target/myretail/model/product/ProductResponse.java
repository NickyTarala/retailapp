package com.target.myretail.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.myretail.error.ApiError;
import io.swagger.annotations.ApiModel;

@lombok.Data
public class ProductResponse {

    @JsonProperty("data")
    private Data data;
    private ApiError apiError;
}
