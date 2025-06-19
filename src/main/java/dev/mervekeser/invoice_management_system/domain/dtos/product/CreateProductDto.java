package dev.mervekeser.invoice_management_system.domain.dtos.product;

import jakarta.validation.constraints.*;

public record CreateProductDto(
        @NotNull @NotBlank @Size(max = 255)
        String description,
        @NotNull @PositiveOrZero
        int quantity,
        @NotNull @Positive
        double unitPrice,
        @NotNull @Positive
        double taxRate
) {
}
