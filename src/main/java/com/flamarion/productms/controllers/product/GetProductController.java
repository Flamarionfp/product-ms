package com.flamarion.productms.controllers.product;

import com.flamarion.productms.core.http.exceptions.HttpException;
import com.flamarion.productms.models.response.ErrorResponse;
import com.flamarion.productms.services.product.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
      try {
        var product = this.getProductService.execute(productId);

        return ResponseEntity.ok().body(product);
      } catch (Exception exception) {
          var parsedException = HttpException.parse(exception);
          var errorResponse = ErrorResponse.builder().message(parsedException.getMessage()).build();

          return ResponseEntity.status(parsedException.getStatus()).body(errorResponse);
      }
    }
}
