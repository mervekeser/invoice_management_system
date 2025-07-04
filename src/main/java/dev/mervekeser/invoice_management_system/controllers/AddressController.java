package dev.mervekeser.invoice_management_system.controllers;

import dev.mervekeser.invoice_management_system.domain.dtos.address.AddressResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.CreateAddressDto;
import dev.mervekeser.invoice_management_system.domain.dtos.address.UpdateAddressDto;
import dev.mervekeser.invoice_management_system.services.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponseDto> createAddress(@RequestBody @Valid CreateAddressDto createAddressDto){
        AddressResponseDto savedAddress = addressService.createAddress(createAddressDto);

        return new ResponseEntity<>(
                savedAddress,
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AddressResponseDto> updateAddress(@Valid @RequestBody UpdateAddressDto updateAddressDto, Long id){
        AddressResponseDto updatedAddress = addressService.updateAddress(updateAddressDto, id);

        return new ResponseEntity<>(
                updatedAddress,
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressResponseDto> getAddress(@PathVariable Long id){
        AddressResponseDto addressResponseDto = addressService.getAddressById(id);

        return ResponseEntity.ok(addressResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<AddressResponseDto>> getAllAddress(){
        List<AddressResponseDto> addressResponseDtos = addressService.getAllAddress();
        return ResponseEntity.ok(addressResponseDtos);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AddressResponseDto> deleteAddress(@PathVariable Long id){
        AddressResponseDto deletedAddress = addressService.deleteAddressById(id);

        return ResponseEntity.ok(deletedAddress);
    }
}
