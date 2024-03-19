package com.flamarion.productms.controllers.product;

import com.flamarion.productms.entities.Product;
import com.flamarion.productms.services.ListProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/product")
public class ListProductsController {
    private final ListProductsService listProductsService;

    @Autowired
    public ListProductsController(ListProductsService listProductsService) {
        this.listProductsService = listProductsService;
    }

    @GetMapping
    public List<Product> handle() {
        return this.listProductsService.execute();
    }
}
