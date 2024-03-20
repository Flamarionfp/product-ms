package com.flamarion.productms.services.product;

import com.flamarion.productms.core.http.exceptions.HttpException;
import com.flamarion.productms.entities.Product;
import com.flamarion.productms.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService {
    private final ProductRepository productRepository;

    @Autowired
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Transactional
    public void execute(String id) {
        Optional<Product> productToDelete = this.productRepository.findById(id);

        if (productToDelete.isEmpty()) throw new HttpException(HttpStatus.NOT_FOUND, "Produto não encontrado");

        this.productRepository.deleteById(id);
    }
}
