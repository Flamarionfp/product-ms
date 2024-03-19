package com.flamarion.productms.controllers.product;

import com.flamarion.productms.services.product.DeleteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class DeleteProductController {
    private final DeleteProductService deleteProductService;

    @Autowired
    public DeleteProductController(DeleteProductService deleteProductService) {
        this.deleteProductService = deleteProductService;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> handle(@PathVariable(name = "id") String productId) {
        this.deleteProductService.execute(productId);

        return ResponseEntity.noContent().build();
    }
}
