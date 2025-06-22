package dev.mervekeser.invoice_management_system.services.impl;

import dev.mervekeser.invoice_management_system.common.exception.DataNotFoundException;
import dev.mervekeser.invoice_management_system.common.exception.ErrorMessage;
import dev.mervekeser.invoice_management_system.common.exception.type.MessageType;
import dev.mervekeser.invoice_management_system.domain.dtos.user.CreateUserDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UpdateUserDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UserResponseDto;
import dev.mervekeser.invoice_management_system.domain.entities.User;
import dev.mervekeser.invoice_management_system.mappers.UserMapper;
import dev.mervekeser.invoice_management_system.repositories.UserRepository;
import dev.mervekeser.invoice_management_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(CreateUserDto createUserDto) {
        User user = userMapper.toEntity(createUserDto);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDto updateUser(UpdateUserDto updateUserDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.USER_NOT_FOUND, id.toString())));

        user.setFirstname(updateUserDto.firstname());
        user.setLastname(updateUserDto.lastname());
        user.setPhone(updateUserDto.phone());
        user.setEmail(updateUserDto.email());
        user.setPassword(updateUserDto.password());

        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.USER_NOT_FOUND, id.toString())));

        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserResponseDto> allUsers = users.stream()
                .map(userMapper::toDto)
                .toList();
        return allUsers;
    }

    @Override
    public UserResponseDto deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.USER_NOT_FOUND, id.toString())));

        userRepository.delete(user);
        UserResponseDto deletedUser = userMapper.toDto(user);
        return deletedUser;
    }
}
