package dev.mervekeser.invoice_management_system.mappers;

import dev.mervekeser.invoice_management_system.domain.dtos.invoice.CreateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.UpdateInvoiceDto;
import dev.mervekeser.invoice_management_system.domain.entities.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceMapper {
    @Mapping(source = "product", target = "productResponseDto")
    @Mapping(source = "company", target = "companyResponseDto")
    @Mapping(source = "payments", target = "paymentResponseDtos")
    InvoiceResponseDto toDto(Invoice invoice);
    Invoice toEntity(CreateInvoiceDto createInvoiceDto);
    Invoice toEntity(UpdateInvoiceDto updateInvoiceDto);
}
