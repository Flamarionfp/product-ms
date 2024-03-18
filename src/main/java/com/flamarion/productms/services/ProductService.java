package com.flamarion.productms.services;

import com.flamarion.productms.domain.entities.Product;
import com.flamarion.productms.dtos.CreateProductDTO;
import com.flamarion.productms.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(CreateProductDTO data) {
        var product = Product.builder().
                name(data.name()).
                brand(data.brand()).
                listPrice(data.listPrice()).
                salePrice(data.salePrice()).
                images(data.images())
                .build();

        return this.productRepository.save(product);
    }
}
