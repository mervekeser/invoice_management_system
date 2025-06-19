package dev.mervekeser.invoice_management_system.domain.dtos.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateAddressDto(
        @Size(max = 255)
        String content,
        @NotBlank
        @NotNull
        @Size(max = 25)
        String city,
        @NotBlank
        @NotNull
        @Size(max = 25 )
        String district,
        @NotNull @Positive
        Long companyId
) {
}
