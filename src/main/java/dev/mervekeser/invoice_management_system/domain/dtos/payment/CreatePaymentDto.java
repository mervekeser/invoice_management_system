package dev.mervekeser.invoice_management_system.domain.dtos.payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record CreatePaymentDto(
        @NotNull(message = "{NotNull.common}")
        @PastOrPresent
        LocalDate date,
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        String paymentMethod,
        @NotNull(message = "{NotNull.common}")
        @Positive(message = "{Positive.common}")
        Long invoiceId
) {
}
