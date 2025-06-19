package dev.mervekeser.invoice_management_system.domain.dtos.payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record CreatePaymentDto(
        @NotNull @PastOrPresent
        LocalDate date,
        @NotNull @NotBlank
        String paymentMethod,
        @NotNull @Positive
        Long invoiceId
) {
}
