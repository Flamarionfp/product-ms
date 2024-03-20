package com.flamarion.productms.controllers.product;

import com.flamarion.productms.dtos.product.UpdateProductDTO;
import com.flamarion.productms.entities.Product;
import com.flamarion.productms.services.product.UpdateProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class UpdateProductController {
    private final UpdateProductService updateProductService;

    @Autowired
    public UpdateProductController(UpdateProductService updateProductService) {
        this.updateProductService = updateProductService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> handle(@PathVariable(name = "id") String productId, @RequestBody @Valid UpdateProductDTO data) {
        var updatedProduct = this.updateProductService.execute(productId, data);

        return ResponseEntity.ok().body(updatedProduct);
    }
}
