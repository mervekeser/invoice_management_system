package dev.mervekeser.invoice_management_system.domain.dtos.product;

public record ProductResponseDto(
        String description,
        int quantity,
        double unitPrice,
        double taxRate
) {
}
