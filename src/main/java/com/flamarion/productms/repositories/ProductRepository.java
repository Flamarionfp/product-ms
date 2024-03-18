package com.flamarion.productms.repositories;

import com.flamarion.productms.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
