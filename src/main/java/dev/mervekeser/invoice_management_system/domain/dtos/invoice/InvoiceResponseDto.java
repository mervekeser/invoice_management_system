package dev.mervekeser.invoice_management_system.domain.dtos.invoice;

import dev.mervekeser.invoice_management_system.domain.dtos.company.CompanyResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.payment.PaymentResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.product.ProductResponseDto;

import java.time.LocalDate;
import java.util.List;

public record InvoiceResponseDto(
        double taxAmount,
        double amount,
        LocalDate issueDate,
        LocalDate dueDate,
        String invoiceStatus,
        ProductResponseDto productResponseDto,
        CompanyResponseDto companyResponseDto,
        List<PaymentResponseDto> paymentResponseDtos
) {
}
