package dev.mervekeser.invoice_management_system.domain.dtos.invoice;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CreateInvoiceDto(
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        double taxAmount,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        double amount,
        @PastOrPresent(message = "{PastOrPresent.common}")
        LocalDate issueDate,
        @Future(message = "{Future.common}")
        LocalDate dueDate,
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        String invoiceStatus,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long productId,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long companyId
) {
}
