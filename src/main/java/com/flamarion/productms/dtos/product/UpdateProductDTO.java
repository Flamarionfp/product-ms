package com.flamarion.productms.dtos.product;

import com.flamarion.productms.utils.RegexPatterns;
import jakarta.validation.constraints.*;

import java.util.List;

public record UpdateProductDTO (
        @Pattern(regexp = RegexPatterns.LETTERS_NUMBERS_SPACES, message = "Nome inválido")
        String name,
        String brand,
        @Positive(message = "Valor inválido")
        Double listPrice,
        @Positive(message = "Valor inválido")
        Double salePrice,
        List<String> images
){
}
