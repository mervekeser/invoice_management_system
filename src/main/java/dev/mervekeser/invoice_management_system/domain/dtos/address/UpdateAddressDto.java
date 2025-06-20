package dev.mervekeser.invoice_management_system.domain.dtos.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateAddressDto(
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long id,
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
        Long companyId,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long userId
) {
}
