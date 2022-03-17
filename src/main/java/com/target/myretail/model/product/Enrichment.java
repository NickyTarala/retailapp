package com.target.myretail.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Enrichment {

    @JsonProperty("images")
    private Images images;
}
