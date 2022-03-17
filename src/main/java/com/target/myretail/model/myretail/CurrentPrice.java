package com.target.myretail.model.myretail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CurrentPrice {

    @ApiModelProperty("value")
    private Double value;

    @ApiModelProperty("currency_code")
    private String currency_code;
}
