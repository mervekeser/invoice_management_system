package dev.mervekeser.invoice_management_system.mappers;

import dev.mervekeser.invoice_management_system.domain.dtos.address.AddressResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.CreateAddressDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.UpdateAddressDto;
import dev.mervekeser.invoice_management_system.domain.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    AddressResponseDto toDto(Address address);
    Address toEntity(CreateAddressDto createAddressDto);
    Address toEntity(UpdateAddressDto updateAddressDto);
}
