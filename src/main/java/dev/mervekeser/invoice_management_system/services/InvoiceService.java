package dev.mervekeser.invoice_management_system.services;

import dev.mervekeser.invoice_management_system.domain.dtos.invoice.CreateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.UpdateInvoiceDto;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDto createInvoice(CreateInvoiceDto createInvoiceDto);
    InvoiceResponseDto updateInvoice(UpdateInvoiceDto updateInvoiceDto, Long id);
    InvoiceResponseDto getInvoiceById(Long id);
    List<InvoiceResponseDto> getAllInvoices();
    InvoiceResponseDto deleteInvoiceById(Long id);
}
