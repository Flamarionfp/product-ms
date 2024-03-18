package com.flamarion.productms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String brand;

    @Column(name = "list_price")
    private double listPrice;

    @Column(name = "sale_price")
    private double salePrice;

    @ElementCollection
    private List<String> images;

    public double getDiscount() {
        return listPrice - salePrice;
    }
}
