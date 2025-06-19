package dev.mervekeser.invoice_management_system.domain.dtos.invoice;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdateInvoiceDto(
        @NotNull @PositiveOrZero
        double taxAmount,
        @NotNull @PositiveOrZero
        double amount,
        @PastOrPresent
        LocalDate issueDate,
        @Future
        LocalDate dueDate,
        @NotNull @NotBlank
        String invoiceStatus,
        @NotNull @Positive
        Long productId,
        @NotNull @Positive
        Long companyId
) {
}
