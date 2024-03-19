package com.flamarion.productms.services;

import com.flamarion.productms.entities.Product;
import com.flamarion.productms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductsService {
    private final ProductRepository productRepository;

    @Autowired
    public ListProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> execute() {
        return this.productRepository.findAll();
    }
}
