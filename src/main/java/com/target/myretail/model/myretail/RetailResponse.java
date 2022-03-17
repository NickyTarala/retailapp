package com.target.myretail.model.myretail;

import com.target.myretail.error.ApiError;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RetailResponse {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("current_price")
    private CurrentPrice current_price;

    private ApiError apiError;
}
