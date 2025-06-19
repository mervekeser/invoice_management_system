package dev.mervekeser.invoice_management_system.domain.dtos.user;

import dev.mervekeser.invoice_management_system.domain.entities.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UpdateUserDto(
        @NotNull @NotBlank @Size(max = 25)
        String firstname,
        @NotNull @NotBlank @Size(max = 25)
        String lastname,
        @NotNull @NotBlank
        String phone,
        @NotNull @NotBlank @Email
        String email,
        @NotNull @NotBlank
        String password,
        List<UserRole> userRoles
) {
}
