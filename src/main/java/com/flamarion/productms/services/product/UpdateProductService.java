package com.flamarion.productms.services.product;

import com.flamarion.productms.core.http.exceptions.HttpException;
import com.flamarion.productms.dtos.product.UpdateProductDTO;
import com.flamarion.productms.entities.Product;
import com.flamarion.productms.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UpdateProductService {
    private final ProductRepository productRepository;

    @Autowired
    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product execute(String id, UpdateProductDTO data) {
        Optional<Product> ProductToUpdate = this.productRepository.findById(id);

        if (ProductToUpdate.isEmpty()) throw new HttpException(HttpStatus.NOT_FOUND, "Produto não encontrado");

        Product product = ProductToUpdate.get();

        if (data.name() != null) product.setName(data.name());
        if (data.brand() != null) product.setBrand(data.brand());
        if (data.listPrice() != null) product.setListPrice(data.listPrice());
        if (data.salePrice() != null) product.setSalePrice(data.salePrice());

        if (data.images() != null) {
            if (data.images().isEmpty()) {
                product.setImages(new ArrayList<>());
            } else {
                var updatedImages = mergeImages(product.getImages(), data.images());
                product.setImages(updatedImages);
            }
        }

        this.productRepository.save(product);

        return product;
    }

    private List<String> mergeImages(List<String> productImages, List<String> newProductImages) {
        Set<String> mergedUniqueImages = new HashSet<>(newProductImages);

        for (String image : productImages) {
            if (mergedUniqueImages.contains(image)) {
                mergedUniqueImages.add(image);
            }
        }

        return new ArrayList<>(mergedUniqueImages);
    }
}
