package com.flamarion.productms.services.product;

import com.flamarion.productms.dtos.product.CreateProductDTO;
import com.flamarion.productms.entities.Product;
import com.flamarion.productms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {
    private final ProductRepository productRepository;

    @Autowired
    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product execute(CreateProductDTO data) {
        var product = Product.builder()
                .name(data.name())
                .brand(data.brand())
                .listPrice(data.listPrice())
                .salePrice(data.salePrice())
                .images(data.images())
                .build();

        return this.productRepository.save(product);
    }
}
