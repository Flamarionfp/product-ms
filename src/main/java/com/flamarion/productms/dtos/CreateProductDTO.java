package com.flamarion.productms.dtos;

import java.util.List;

public record CreateProductDTO(String name, String brand, double listPrice, double salePrice, List<String> images) {
}
