package dev.mervekeser.invoice_management_system.domain.dtos.address;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DeleteAddressDto(
        @NotNull @Positive
        Long id
) {
}
