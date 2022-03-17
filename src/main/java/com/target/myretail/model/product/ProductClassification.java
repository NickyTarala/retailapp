package com.target.myretail.model.product;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductClassification {

    @JsonProperty("product_type_name")
    private String productTypeName;

    @JsonProperty("merchandise_type_name")
    private String merchandiseTypeName;
}
