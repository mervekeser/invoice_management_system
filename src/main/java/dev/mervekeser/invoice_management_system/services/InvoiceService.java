package dev.mervekeser.invoice_management_system.services;

import dev.mervekeser.invoice_management_system.domain.dtos.invoice.CreateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.UpdateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.entities.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDto createInvoice(CreateInvoiceDto createInvoiceDto);
    InvoiceResponseDto updateInvoice(UpdateInvoiceDto updateInvoiceDto, Long id);
    InvoiceResponseDto getInvoiceById(Long id);
    List<InvoiceResponseDto> getAllInvoices();
    InvoiceResponseDto deleteInvoiceById(Long id);
    Invoice getInvoice(Long id);
    Page<InvoiceResponseDto> getAllInvoiceWithPage(Pageable pageable);
}
