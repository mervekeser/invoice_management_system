package dev.mervekeser.invoice_management_system.services.impl;

import dev.mervekeser.invoice_management_system.common.exception.DataNotFoundException;
import dev.mervekeser.invoice_management_system.common.exception.ErrorMessage;
import dev.mervekeser.invoice_management_system.common.exception.type.MessageType;
import dev.mervekeser.invoice_management_system.domain.dtos.address.AddressResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.CreateAddressDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.UpdateAddressDto;
import dev.mervekeser.invoice_management_system.domain.entities.Address;
import dev.mervekeser.invoice_management_system.domain.entities.Company;
import dev.mervekeser.invoice_management_system.domain.entities.User;
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
    private final CompanyServiceImpl companyService;
    private final UserServiceImpl userService;

    @Override
    public AddressResponseDto createAddress(CreateAddressDto createAddressDto) {
        Address address = addressMapper.toEntity(createAddressDto);
        Company company = companyService.getCompany(createAddressDto.companyId());

        if(company == null){
            throw new DataNotFoundException(new ErrorMessage(MessageType.COMPANY_NOT_FOUND, createAddressDto.companyId().toString()));
        }

        User user = userService.getUser(createAddressDto.userId());

        if(user == null){
            throw new DataNotFoundException((new ErrorMessage(MessageType.USER_NOT_FOUND, createAddressDto.userId().toString())));
        }
        address.setCompany(company);
        address.setUser(user);

        addressRepository.save(address);

        return addressMapper.toDto(address);
    }

    @Override
    public AddressResponseDto updateAddress(UpdateAddressDto updateAddressDto, Long id) {
        Address address = addressRepository.findById(id)
                        .orElseThrow(()-> new DataNotFoundException(
                                new ErrorMessage(MessageType.ADDRESS_NOT_FOUND, id.toString())
                        ));

        address.setContent(updateAddressDto.content());
        address.setCity(updateAddressDto.city());
        address.setDistrict(updateAddressDto.district());

        Company company = companyService.getCompany(updateAddressDto.companyId());
        User user = userService.getUser(updateAddressDto.userId());

        if(company == null){
            throw new DataNotFoundException(new ErrorMessage(MessageType.COMPANY_NOT_FOUND, updateAddressDto.companyId().toString()));
        }

        if(user == null){
            throw new DataNotFoundException((new ErrorMessage(MessageType.USER_NOT_FOUND, updateAddressDto.userId().toString())));
        }

        address.setCompany(company);
        address.setUser(user);

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
    public AddressResponseDto deleteAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.ADDRESS_NOT_FOUND, id.toString())));
        addressRepository.delete(address);
        return addressMapper.toDto(address);
    }
}
