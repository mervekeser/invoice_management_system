package dev.mervekeser.invoice_management_system.domain.dtos.payment;

import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;

import java.time.LocalDate;

public record PaymentResponseDto(
        LocalDate date,
        String paymentMethod,
        InvoiceResponseDto invoiceResponseDto
) {
}
