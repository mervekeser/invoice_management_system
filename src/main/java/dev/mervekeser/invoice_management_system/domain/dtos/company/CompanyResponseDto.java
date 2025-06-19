package dev.mervekeser.invoice_management_system.domain.dtos.company;

import dev.mervekeser.invoice_management_system.domain.dtos.address.AddressResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.invoice.InvoiceResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UserResponseDto;

import java.util.List;

public record CompanyResponseDto(
        String name,
        String phone,
        String email,
        String taxNumber,
        List<InvoiceResponseDto> invoiceResponseDtos,
        UserResponseDto userResponseDto,
        List<AddressResponseDto> addressResponseDtos
) {
}
