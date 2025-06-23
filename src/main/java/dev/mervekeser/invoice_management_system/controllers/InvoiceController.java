package dev.mervekeser.invoice_management_system.controllers;

import dev.mervekeser.invoice_management_system.domain.dtos.invoice.CreateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.UpdateInvoiceDto;
import dev.mervekeser.invoice_management_system.services.impl.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/invoices")
public class InvoiceController {
    private final InvoiceServiceImpl invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceResponseDto> createInvoice(CreateInvoiceDto createInvoiceDto){
        InvoiceResponseDto savedInvoice = invoiceService.createInvoice(createInvoiceDto);

        return new ResponseEntity<>(
                savedInvoice,
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<InvoiceResponseDto> updateInvoice(UpdateInvoiceDto updateInvoiceDto, Long id){
        InvoiceResponseDto updatedInvoice = invoiceService.updateInvoice(updateInvoiceDto, id);

        return new ResponseEntity<>(
                updatedInvoice,
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<InvoiceResponseDto> getInvoice(Long id){
        InvoiceResponseDto getInvoiceById = invoiceService.getInvoiceById(id);

        return ResponseEntity.ok(getInvoiceById);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceResponseDto>> getAllInvoice(){
        List<InvoiceResponseDto> invoices = invoiceService.getAllInvoices();

        return ResponseEntity.ok(invoices);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<InvoiceResponseDto> deleteInvoice(Long id){
        InvoiceResponseDto deletedInvoice = invoiceService.deleteInvoiceById(id);

        return ResponseEntity.ok(deletedInvoice);
    }
}
