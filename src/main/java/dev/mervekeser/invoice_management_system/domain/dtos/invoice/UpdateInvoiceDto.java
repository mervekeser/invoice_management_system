package dev.mervekeser.invoice_management_system.domain.dtos.invoice;

import dev.mervekeser.invoice_management_system.domain.entities.enums.InvoiceStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdateInvoiceDto(
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        double taxAmount,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        double amount,
        @PastOrPresent
        LocalDate issueDate,
        @Future
        LocalDate dueDate,
        InvoiceStatus invoiceStatus,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long productId,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long companyId
) {
}
