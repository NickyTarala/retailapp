package com.target.myretail.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductDescription {

    @JsonProperty("title")
    private String title;

    @JsonProperty("downstream_description")
    private String downstreamDescription;
}
