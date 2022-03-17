package com.target.myretail.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/target/api")
@Slf4j
public class HealthCheckController {

    @ApiOperation(value = "healthcheck", nickname = "healthcheck")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "myRetail API is up and running",
                    response = String.class, responseContainer = "String") })
    @RequestMapping(method = RequestMethod.GET, value = "/status")

    public ResponseEntity<String> healthCheck(){
        log.info("Target - MyRetail API is up and running");
        return ResponseEntity.ok("Target - MyRetail API is up and running on: "+ new Date());
    }
}
