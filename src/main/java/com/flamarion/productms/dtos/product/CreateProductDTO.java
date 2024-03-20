package com.flamarion.productms.dtos.product;

import com.flamarion.productms.utils.RegexPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateProductDTO (
        @Pattern(regexp = RegexPatterns.LETTERS_NUMBERS_SPACES, message = "Nome inválido")
        @NotBlank(message = "Nome obrigatório")
        String name,
        @NotBlank(message = "Marca obrigatória")
        String brand,
        @Positive(message = "Valor inválido")
        double listPrice,
        @Positive(message = "Valor inválido")
        double salePrice,
        @NotEmpty(message = "A lista de imagens não pode estar vazia")
        List<String> images
) {
}
