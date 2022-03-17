package com.target.myretail.utils;

import com.target.myretail.common.RetailConstants;
import com.target.myretail.error.ApiError;
import com.target.myretail.model.myretail.RetailResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RetailUtils {

    public boolean validateProductId(@NonNull String productId, RetailResponse retailResponse) {
        if (!StringUtils.isNumeric(productId) && productId.length()==8) {
            String message = "ProductId must be a non-empty numeric value of length 8";
            log.error("ProductId is not valid to fetch information for productId - {}", productId);
            retailResponse.setApiError(new ApiError(RetailConstants.NOT_FOUND_ERROR, RetailConstants.NOT_FOUND, message));
            return false;
        }
        return true;
    }
}
