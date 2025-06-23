package dev.mervekeser.invoice_management_system.domain.dtos.company;

import jakarta.validation.constraints.*;

public record UpdateCompanyDto(
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        @Size(max = 25, message = "{Size.common}")
        String name,
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        String phone,
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        @Email
        String email,
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        String taxNumber,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long userId
) {
}
