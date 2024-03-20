package com.flamarion.productms.services.product;

import com.flamarion.productms.core.http.exceptions.HttpException;
import com.flamarion.productms.dtos.product.CreateProductDTO;
import com.flamarion.productms.entities.Product;
import com.flamarion.productms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {
    private final ProductRepository productRepository;

    @Autowired
    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product execute(CreateProductDTO data) {
        var previousProduct = this.productRepository.findByName(data.name());

        if (previousProduct.isPresent()) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "O produto já existe");
        }

        if (data.salePrice() > data.listPrice()) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "O preço de venda não pode ser maior que o preço de lista");
        }

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
