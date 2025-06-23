package dev.mervekeser.invoice_management_system.services.impl;

import dev.mervekeser.invoice_management_system.common.exception.DataNotFoundException;
import dev.mervekeser.invoice_management_system.common.exception.ErrorMessage;
import dev.mervekeser.invoice_management_system.common.exception.type.MessageType;
import dev.mervekeser.invoice_management_system.domain.dtos.payment.CreatePaymentDto;
import dev.mervekeser.invoice_management_system.domain.dtos.payment.PaymentResponseDto;
import dev.mervekeser.invoice_management_system.domain.entities.Invoice;
import dev.mervekeser.invoice_management_system.domain.entities.Payment;
import dev.mervekeser.invoice_management_system.mappers.PaymentMapper;
import dev.mervekeser.invoice_management_system.repositories.PaymentRepository;
import dev.mervekeser.invoice_management_system.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final InvoiceServiceImpl invoiceService;

    @Override
    public PaymentResponseDto createPayment(CreatePaymentDto createPaymentDto) {
        Payment payment = paymentMapper.toEntity(createPaymentDto);

        Invoice invoice = invoiceService.getInvoice(createPaymentDto.invoiceId());

        if(invoice == null){
            throw new DataNotFoundException(
                    new ErrorMessage(MessageType.INVOICE_NOT_FOUND, createPaymentDto.invoiceId().toString())
            );
        }

        payment.setInvoice(invoice);
        paymentRepository.save(payment);

        return paymentMapper.toDto(payment);
    }



    @Override
    public PaymentResponseDto getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(
                        new ErrorMessage(MessageType.PAYMENT_NOT_FOUND, id.toString())
                ));

        return paymentMapper.toDto(payment);
    }

    @Override
    public List<PaymentResponseDto> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();

        List<PaymentResponseDto> getAllPayment = payments.stream()
                .map(paymentMapper::toDto)
                .toList();

        return getAllPayment;
    }

    @Override
    public PaymentResponseDto deletePaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(
                        new ErrorMessage(MessageType.PAYMENT_NOT_FOUND, id.toString())
                ));
        paymentRepository.delete(payment);

        return paymentMapper.toDto(payment);
    }
}
