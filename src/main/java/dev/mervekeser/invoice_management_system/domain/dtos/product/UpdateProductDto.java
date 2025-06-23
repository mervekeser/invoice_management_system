package dev.mervekeser.invoice_management_system.domain.dtos.product;

import jakarta.validation.constraints.*;

public record UpdateProductDto(
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        @Size(max = 255, message = "{Size.common}")
        String description,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        int quantity,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        double unitPrice,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        double taxRate
) {
}
