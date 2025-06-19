package dev.mervekeser.invoice_management_system.domain.dtos.user;

import dev.mervekeser.invoice_management_system.domain.dtos.address.AddressResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.CompanyResponseDto;
import dev.mervekeser.invoice_management_system.domain.entities.enums.UserRole;

import java.util.List;

public record UserResponseDto(
        String firstname,
        String lastname,
        String phone,
        String email,
        String password,
        List<UserRole> userRoles,
        List<CompanyResponseDto> companyResponseDtos,
        List<AddressResponseDto> addressResponseDtos
) {
}
