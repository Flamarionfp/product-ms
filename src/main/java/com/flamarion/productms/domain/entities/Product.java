package com.flamarion.productms.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
