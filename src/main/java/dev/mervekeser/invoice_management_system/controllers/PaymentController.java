package dev.mervekeser.invoice_management_system.controllers;

import dev.mervekeser.invoice_management_system.domain.dtos.payment.CreatePaymentDto;
import dev.mervekeser.invoice_management_system.domain.dtos.payment.PaymentResponseDto;
import dev.mervekeser.invoice_management_system.services.impl.PaymentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/payments")
public class PaymentController {
    private final PaymentServiceImpl paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDto> createPayment(@Valid @RequestBody CreatePaymentDto createPaymentDto){
        PaymentResponseDto createdPayment = paymentService.createPayment(createPaymentDto);

        return new ResponseEntity<>(
                createdPayment,
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<PaymentResponseDto> getPayment(@PathVariable Long id){
        PaymentResponseDto getPaymentById = paymentService.getPaymentById(id);

        return ResponseEntity.ok(getPaymentById);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDto>> getAllPayment(){
        List<PaymentResponseDto> payments = paymentService.getAllPayments();

        return ResponseEntity.ok(payments);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<PaymentResponseDto> deletePayment(@PathVariable Long id){
        PaymentResponseDto deletedPayment = paymentService.deletePaymentById(id);

        return ResponseEntity.ok(deletedPayment);
    }
}
