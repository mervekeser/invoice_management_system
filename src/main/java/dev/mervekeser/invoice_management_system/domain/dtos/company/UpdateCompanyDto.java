package dev.mervekeser.invoice_management_system.domain.dtos.company;

import jakarta.validation.constraints.*;

public record UpdateCompanyDto(
        @NotNull @NotBlank @Size(max = 25)
        String name,
        @NotNull @NotBlank
        String phone,
        @NotNull @NotBlank @Email
        String email,
        @NotNull @NotBlank
        String taxNumber,
        @NotNull @Positive
        Long userId
) {
}
