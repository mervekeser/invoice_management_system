package dev.mervekeser.invoice_management_system.domain.dtos.address;

public record UpdateAddressDto(
        Long id,
        String content,
        String city,
        String district
) {
}
