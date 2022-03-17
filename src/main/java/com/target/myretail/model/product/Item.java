package com.target.myretail.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Item {

    @JsonProperty("product_description")
    private ProductDescription productDescription;

    @JsonProperty("enrichment")
    private Enrichment enrichment;

    @JsonProperty("product_classification")
    private ProductClassification productClassification;

    @JsonProperty("primary_brand")
    private PrimaryBrand primaryBrand ;
}
