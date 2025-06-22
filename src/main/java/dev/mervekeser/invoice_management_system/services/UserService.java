package dev.mervekeser.invoice_management_system.services;

import dev.mervekeser.invoice_management_system.domain.dtos.user.CreateUserDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UpdateUserDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(CreateUserDto createUserDto);
    UserResponseDto updateUser(UpdateUserDto updateUserDto, Long id);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto deleteUserById(Long id);

}
