package dev.mervekeser.invoice_management_system.controllers;

import dev.mervekeser.invoice_management_system.domain.dtos.invoice.CreateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.UpdateInvoiceDto;
import dev.mervekeser.invoice_management_system.services.InvoiceService;
import dev.mervekeser.invoice_management_system.common.utils.rest.RestRootEntity;
import dev.mervekeser.invoice_management_system.common.utils.pagination.PageUtil;
import dev.mervekeser.invoice_management_system.common.utils.pagination.PageableEntity;
import dev.mervekeser.invoice_management_system.common.utils.pagination.PageableRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public RestRootEntity<InvoiceResponseDto> createInvoice(@Valid @RequestBody CreateInvoiceDto createInvoiceDto){
        InvoiceResponseDto savedInvoice = invoiceService.createInvoice(createInvoiceDto);

        return RestRootEntity.created(savedInvoice);
    }

    @PutMapping(path = "{id}")
    public RestRootEntity<InvoiceResponseDto> updateInvoice(@Valid @RequestBody  UpdateInvoiceDto updateInvoiceDto, Long id){
        InvoiceResponseDto updatedInvoice = invoiceService.updateInvoice(updateInvoiceDto, id);

        return  RestRootEntity.created( updatedInvoice);
    }

    @GetMapping(path = "{id}")
    public RestRootEntity<InvoiceResponseDto> getInvoice(@PathVariable Long id){
        InvoiceResponseDto getInvoiceById = invoiceService.getInvoiceById(id);

        return RestRootEntity.ok(getInvoiceById);
    }

    @GetMapping
    public RestRootEntity<List<InvoiceResponseDto>> getAllInvoice(){
        List<InvoiceResponseDto> invoices = invoiceService.getAllInvoices();

        return RestRootEntity.ok(invoices);
    }

    @GetMapping("/pageable")
    public RestRootEntity<PageableEntity<InvoiceResponseDto>> getAllInvoiceWithPage(PageableRequest pageableRequest){
        Pageable invoicesPage = PageUtil.toPageable(pageableRequest);
        Page<InvoiceResponseDto> invoicesByPage = invoiceService.getAllInvoiceWithPage(invoicesPage);
        PageableEntity<InvoiceResponseDto> invoicePageResponse = PageUtil.toPageableResponse(invoicesByPage, invoicesByPage.getContent());

        return RestRootEntity.ok(invoicePageResponse);
    }

    @DeleteMapping(path = "{id}")
    public RestRootEntity<InvoiceResponseDto> deleteInvoice(@PathVariable Long id){
        InvoiceResponseDto deletedInvoice = invoiceService.deleteInvoiceById(id);

        return RestRootEntity.ok(deletedInvoice);
    }
}
