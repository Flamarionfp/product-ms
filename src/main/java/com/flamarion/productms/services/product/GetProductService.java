package com.flamarion.productms.services.product;

import com.flamarion.productms.entities.Product;
import com.flamarion.productms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService {
    private final ProductRepository productRepository;

    @Autowired
    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> execute(String id) {
        return this.productRepository.findById(id);
    }
}
