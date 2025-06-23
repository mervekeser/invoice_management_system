package dev.mervekeser.invoice_management_system.domain.dtos.company;

import dev.mervekeser.invoice_management_system.domain.dtos.address.AddressResponseDto;

import java.util.List;

public record CompanyResponseDto(
        String name,
        String phone,
        String email,
        String taxNumber,
        List<AddressResponseDto> addressResponseDtos
) {
}
