package com.flamarion.productms.controllers.product;

import com.flamarion.productms.services.product.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class GetProductController {
    private final GetProductService getProductService;

    @Autowired
    public GetProductController(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> handle(@PathVariable(name = "id") String productId) {
        var product = this.getProductService.execute(productId);

        if (product.isPresent()) {
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
