package dev.mervekeser.invoice_management_system.domain.dtos.address;

public record AddressResponseDto(
        String content,
        String city,
        String district
) {
}
