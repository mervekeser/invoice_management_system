package dev.mervekeser.invoice_management_system.mappers;

import dev.mervekeser.invoice_management_system.domain.dtos.payment.CreatePaymentDto;
import dev.mervekeser.invoice_management_system.domain.dtos.payment.PaymentResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.payment.UpdatePaymentDto;
import dev.mervekeser.invoice_management_system.domain.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {
    PaymentResponseDto toDto(Payment payment);
    Payment toEntity(CreatePaymentDto createPaymentDto);
    Payment toEntity(UpdatePaymentDto updatePaymentDto);
}
