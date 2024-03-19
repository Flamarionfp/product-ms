package com.flamarion.productms.controllers.product;

import com.flamarion.productms.dtos.CreateProductDTO;
import com.flamarion.productms.entities.Product;
import com.flamarion.productms.services.CreateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class CreateProductController {
    private final CreateProductService createProductService;

    @Autowired
    public CreateProductController(CreateProductService createProductService) {
        this.createProductService = createProductService;
    }

    @PostMapping
    public ResponseEntity<Product> handle(@RequestBody CreateProductDTO body) {
        var createdProduct = createProductService.execute(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
}
