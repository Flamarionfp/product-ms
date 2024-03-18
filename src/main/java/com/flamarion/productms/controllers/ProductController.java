package com.flamarion.productms.controllers;

import com.flamarion.productms.domain.entities.Product;
import com.flamarion.productms.dtos.CreateProductDTO;
import com.flamarion.productms.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody CreateProductDTO product) {
        var createdProduct = this.productService.create(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
}
