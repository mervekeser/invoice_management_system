package dev.mervekeser.invoice_management_system.services.impl;

import dev.mervekeser.invoice_management_system.common.exception.DataNotFoundException;
import dev.mervekeser.invoice_management_system.common.exception.ErrorMessage;
import dev.mervekeser.invoice_management_system.common.exception.InvoiceStatusException;
import dev.mervekeser.invoice_management_system.common.exception.type.MessageType;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.CreateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.UpdateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.entities.Company;
import dev.mervekeser.invoice_management_system.domain.entities.Invoice;
import dev.mervekeser.invoice_management_system.domain.entities.Product;
import dev.mervekeser.invoice_management_system.domain.entities.enums.InvoiceStatus;
import dev.mervekeser.invoice_management_system.mappers.InvoiceMapper;
import dev.mervekeser.invoice_management_system.repositories.InvoiceRepository;
import dev.mervekeser.invoice_management_system.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final ProductServiceImpl productService;
    private final CompanyServiceImpl companyService;

    @Override
    public InvoiceResponseDto createInvoice(CreateInvoiceDto createInvoiceDto) {
        Invoice invoice = invoiceMapper.toEntity(createInvoiceDto);

        Product product = productService.getProduct(createInvoiceDto.productId());
        if(product == null){
            throw new DataNotFoundException(
                    new ErrorMessage(MessageType.PRODUCT_NOT_FOUND, createInvoiceDto.productId().toString())
            );
        }

        Company company = companyService.getCompany(createInvoiceDto.companyId());
        if(company == null){
            throw new DataNotFoundException(
                    new ErrorMessage(MessageType.COMPANY_NOT_FOUND, createInvoiceDto.companyId().toString())
            );
        }

        invoice.setProduct(product);
        invoice.setCompany(company);

        invoiceRepository.save(invoice);

        return invoiceMapper.toDto(invoice);
    }

    @Override
    public InvoiceResponseDto updateInvoice(UpdateInvoiceDto updateInvoiceDto, Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.INVOICE_NOT_FOUND, id.toString())));

        if(invoice.getInvoiceStatus() != InvoiceStatus.DRAFT){
            throw new InvoiceStatusException(
                    new ErrorMessage(MessageType.INVOICE_STATUS_NOT_AVAILABLE, InvoiceStatus.DRAFT.getInvoiceMethod())
            );
        }

        invoice.setTaxAmount(updateInvoiceDto.taxAmount());
        invoice.setAmount(updateInvoiceDto.amount());
        invoice.setIssueDate(updateInvoiceDto.issueDate());
        invoice.setInvoiceStatus(updateInvoiceDto.invoiceStatus());

        Product product = productService.getProduct(updateInvoiceDto.productId());
        if(product == null){
            throw new DataNotFoundException(
                    new ErrorMessage(MessageType.PRODUCT_NOT_FOUND, updateInvoiceDto.productId().toString())
            );
        }
        invoice.setProduct(product);

        Company company = companyService.getCompany(updateInvoiceDto.companyId());
        if(company == null){
            throw new DataNotFoundException(
                    new ErrorMessage(MessageType.COMPANY_NOT_FOUND, updateInvoiceDto.companyId().toString())
            );
        }
        invoice.setCompany(company);

        invoiceRepository.save(invoice);

        return invoiceMapper.toDto(invoice);
    }

    @Override
    public InvoiceResponseDto getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(
                        new ErrorMessage(MessageType.INVOICE_NOT_FOUND, id.toString())
                ));


        return invoiceMapper.toDto(invoice);
    }

    @Override
    public List<InvoiceResponseDto> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<InvoiceResponseDto> getAllInvoice = invoices.stream()
                .map(invoiceMapper::toDto)
                .toList();

        return getAllInvoice;
    }

    @Override
    public InvoiceResponseDto deleteInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(
                        new ErrorMessage(MessageType.INVOICE_NOT_FOUND, id.toString())
                ));
        invoiceRepository.delete(invoice);
        return invoiceMapper.toDto(invoice);
    }
}
