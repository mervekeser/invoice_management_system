package dev.mervekeser.invoice_management_system.domain.dtos.address;

import dev.mervekeser.invoice_management_system.domain.dtos.company.CompanyResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UserResponseDto;

public record AddressResponseDto(
        String content,
        String city,
        String district
) {
}
