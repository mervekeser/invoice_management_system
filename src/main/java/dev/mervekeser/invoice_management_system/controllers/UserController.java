package dev.mervekeser.invoice_management_system.controllers;

import dev.mervekeser.invoice_management_system.domain.dtos.user.CreateUserDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UpdateUserDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UserResponseDto;
import dev.mervekeser.invoice_management_system.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody CreateUserDto createUserDto){
        UserResponseDto savedUser = userService.createUser(createUserDto);

        return new ResponseEntity<>(
                savedUser,
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<UserResponseDto> updateUser(@Valid @RequestBody UpdateUserDto updateUserDto, Long id){
        UserResponseDto updatedUser = userService.updateUser(updateUserDto, id);

        return new ResponseEntity<>(
                updatedUser,
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id){
        UserResponseDto getUserById = userService.getUserById(id);

        return ResponseEntity.ok(getUserById);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        List<UserResponseDto> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<UserResponseDto> deleteUser(Long id){
        UserResponseDto deletedUser = userService.deleteUserById(id);

        return ResponseEntity.ok(deletedUser);
    }
}
