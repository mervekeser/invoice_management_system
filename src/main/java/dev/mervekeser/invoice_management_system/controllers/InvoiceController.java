package dev.mervekeser.invoice_management_system.controllers;

import dev.mervekeser.invoice_management_system.domain.dtos.invoice.CreateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.UpdateInvoiceDto;
import dev.mervekeser.invoice_management_system.services.InvoiceService;
import dev.mervekeser.invoice_management_system.utils.pagination.PageUtil;
import dev.mervekeser.invoice_management_system.utils.pagination.PageableEntity;
import dev.mervekeser.invoice_management_system.utils.pagination.PageableRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceResponseDto> createInvoice(@Valid @RequestBody CreateInvoiceDto createInvoiceDto){
        InvoiceResponseDto savedInvoice = invoiceService.createInvoice(createInvoiceDto);

        return new ResponseEntity<>(
                savedInvoice,
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<InvoiceResponseDto> updateInvoice(@Valid @RequestBody  UpdateInvoiceDto updateInvoiceDto, Long id){
        InvoiceResponseDto updatedInvoice = invoiceService.updateInvoice(updateInvoiceDto, id);

        return new ResponseEntity<>(
                updatedInvoice,
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<InvoiceResponseDto> getInvoice(@PathVariable Long id){
        InvoiceResponseDto getInvoiceById = invoiceService.getInvoiceById(id);

        return ResponseEntity.ok(getInvoiceById);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceResponseDto>> getAllInvoice(){
        List<InvoiceResponseDto> invoices = invoiceService.getAllInvoices();

        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/pageable")
    public ResponseEntity<PageableEntity<InvoiceResponseDto>> getAllInvoiceWithPage(PageableRequest pageableRequest){
        Pageable invoicesPage = PageUtil.toPageable(pageableRequest);
        Page<InvoiceResponseDto> invoicesByPage = invoiceService.getAllInvoiceWithPage(invoicesPage);
        PageableEntity<InvoiceResponseDto> invoicePageResponse = PageUtil.toPageableResponse(invoicesByPage, invoicesByPage.getContent());

        return ResponseEntity.ok(invoicePageResponse);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<InvoiceResponseDto> deleteInvoice(@PathVariable Long id){
        InvoiceResponseDto deletedInvoice = invoiceService.deleteInvoiceById(id);

        return ResponseEntity.ok(deletedInvoice);
    }
}
