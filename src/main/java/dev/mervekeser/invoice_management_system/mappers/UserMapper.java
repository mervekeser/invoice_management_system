package dev.mervekeser.invoice_management_system.mappers;

import dev.mervekeser.invoice_management_system.domain.dtos.user.CreateUserDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UpdateUserDto;
import dev.mervekeser.invoice_management_system.domain.dtos.user.UserResponseDto;
import dev.mervekeser.invoice_management_system.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(source = "companies", target = "companyResponseDtos")
    @Mapping(source = "addresses", target = "addressResponseDtos")
    UserResponseDto toDto(User user);
    User toEntity(CreateUserDto createUserDto);
    User toEntity(UpdateUserDto updateUserDto);
}
