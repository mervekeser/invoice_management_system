package dev.mervekeser.invoice_management_system.domain.dtos.address;

import jakarta.validation.constraints.*;

public record CreateAddressDto(
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        @Size(max = 255, message = "{Size.common}")
        String content,
        @NotBlank(message = "{NotBlank.common}")
        @Size(max = 25, message = "{Size.common}")
        String city,
        @NotBlank(message = "{NotBlank.common}")
        @Size(max = 25, message = "{Size.common}")
        String district,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long userId,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long companyId
) {
}
