package com.flamarion.productms.services.product;

import com.flamarion.productms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {
    private final ProductRepository productRepository;

    @Autowired
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void execute(String id) {
        this.productRepository.deleteById(id);
    }
}
