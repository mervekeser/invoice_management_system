package dev.mervekeser.invoice_management_system.services.impl;

import dev.mervekeser.invoice_management_system.common.exception.AlreadyExistsException;
import dev.mervekeser.invoice_management_system.common.exception.DataNotFoundException;
import dev.mervekeser.invoice_management_system.common.exception.ErrorMessage;
import dev.mervekeser.invoice_management_system.common.exception.type.MessageType;
import dev.mervekeser.invoice_management_system.domain.dtos.address.AddressResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.CreateAddressDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.UpdateAddressDto;
import dev.mervekeser.invoice_management_system.domain.entities.Address;
import dev.mervekeser.invoice_management_system.domain.entities.RootEntity;
import dev.mervekeser.invoice_management_system.mappers.AddressMapper;
import dev.mervekeser.invoice_management_system.repositories.AddressRepository;
import dev.mervekeser.invoice_management_system.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;


    @Override
    public AddressResponseDto createAddress(CreateAddressDto createAddressDto) {

        Address address1 = addressRepository.findByContent(createAddressDto.content());

        if(address1.getContent() != null){
            throw new AlreadyExistsException(new ErrorMessage(MessageType.ADDRESS_ALREADY_EXISTS, createAddressDto.content()));
        }

        if(createAddressDto.companyId() == null){
            throw new DataNotFoundException(new ErrorMessage(MessageType.COMPANY_NOT_FOUND, createAddressDto.companyId().toString()));
        }

        if(createAddressDto.userId() == null){
            throw new DataNotFoundException((new ErrorMessage(MessageType.USER_NOT_FOUND, createAddressDto.userId().toString())));
        }
        Address address = addressMapper.toEntity(createAddressDto);
        addressRepository.save(address);

        return addressMapper.toDto(address);
    }

    @Override
    public AddressResponseDto updateAddress(UpdateAddressDto updateAddressDto) {
        addressRepository.findById(updateAddressDto.id())
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.ADDRESS_NOT_FOUND, updateAddressDto.id().toString())));
        Address address = addressMapper.toEntity(updateAddressDto);
        addressRepository.save(address);
        return addressMapper.toDto(address);
    }

    @Override
    public AddressResponseDto getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.ADDRESS_NOT_FOUND, id.toString())));
        return addressMapper.toDto(address);
    }

    @Override
    public List<AddressResponseDto> getAllAddress() {
        List<Address> addresses = addressRepository.findAll();

        List<AddressResponseDto> addressResponseDtos = addresses.stream()
                .map(addressMapper::toDto)
                .toList();
        return addressResponseDtos;
    }

    @Override
    public AddressResponseDto deleteAddress(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.ADDRESS_NOT_FOUND, id.toString())));
        addressRepository.delete(address);
        return addressMapper.toDto(address);
    }
}
