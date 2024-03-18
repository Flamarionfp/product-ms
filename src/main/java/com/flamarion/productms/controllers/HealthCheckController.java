package com.flamarion.productms.controllers;

import com.flamarion.productms.models.response.HealthCheckResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health-check")
public class HealthCheckController {
    @GetMapping
    public ResponseEntity<HealthCheckResponse> verify() {
        var healthCheckResponse = new HealthCheckResponse(true);

        return ResponseEntity.ok(healthCheckResponse);
    }
}
