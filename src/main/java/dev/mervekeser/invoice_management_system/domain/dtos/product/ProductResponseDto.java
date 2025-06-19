package dev.mervekeser.invoice_management_system.domain.dtos.product;

import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;

import java.util.List;

public record ProductResponseDto(
        String description,
        int quantity,
        double unitPrice,
        double taxRate
) {
}
