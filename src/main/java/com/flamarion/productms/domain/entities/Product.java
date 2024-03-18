package com.flamarion.productms.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String brand;

    private double listPrice;

    private double salePrice;

    @ElementCollection
    private List<String> images;

    public double getDiscount() {
        return listPrice - salePrice;
    }
}
