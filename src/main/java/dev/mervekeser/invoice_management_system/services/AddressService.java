package dev.mervekeser.invoice_management_system.services;

import dev.mervekeser.invoice_management_system.domain.dtos.address.AddressResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.CreateAddressDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.UpdateAddressDto;
import dev.mervekeser.invoice_management_system.domain.entities.RootEntity;

import java.util.List;

public interface AddressService {
    AddressResponseDto createAddress(CreateAddressDto createAddressDto);
    AddressResponseDto updateAddress(UpdateAddressDto updateAddressDto);
    AddressResponseDto getAddressById(Long id);
    List<AddressResponseDto> getAllAddress();
    AddressResponseDto deleteAddressById(Long id);
}
