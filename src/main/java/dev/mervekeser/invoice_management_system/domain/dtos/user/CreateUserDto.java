package dev.mervekeser.invoice_management_system.domain.dtos.user;

import dev.mervekeser.invoice_management_system.domain.entities.enums.UserRole;
import jakarta.validation.constraints.*;

import java.util.List;

public record CreateUserDto(
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        @Size(max = 25, message = "{Size.common}")
        String firstname,
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        @Size(max = 25, message = "{Size.common}")
        String lastname,
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        String phone,
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        @Email(message = "{Email.common}")
        String email,
        @NotNull(message = "{NotNull.common}")
        @NotBlank(message = "{NotBlank.common}")
        String password,
        List<UserRole> userRoles
) {
}
