package com.target.myretail.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Images {

    @JsonProperty("primary_image_url")
    private String primaryImageUrl;
}
