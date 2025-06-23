package dev.mervekeser.invoice_management_system.services;

import dev.mervekeser.invoice_management_system.domain.dtos.payment.CreatePaymentDto;
import dev.mervekeser.invoice_management_system.domain.dtos.payment.PaymentResponseDto;

import java.util.List;

public interface PaymentService {
    PaymentResponseDto createPayment(CreatePaymentDto createPaymentDto);
    PaymentResponseDto getPaymentById(Long id);
    List<PaymentResponseDto> getAllPayments();
    PaymentResponseDto deletePaymentById(Long id);
}
