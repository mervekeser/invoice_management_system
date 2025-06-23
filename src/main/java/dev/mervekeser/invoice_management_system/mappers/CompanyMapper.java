package dev.mervekeser.invoice_management_system.mappers;

import dev.mervekeser.invoice_management_system.domain.dtos.company.CompanyResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.CreateCompanyDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.UpdateCompanyDto;
import dev.mervekeser.invoice_management_system.domain.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
    @Mapping(source = "addresses", target = "addressResponseDtos")
    CompanyResponseDto toDto(Company company);
    Company toEntity(CreateCompanyDto createCompanyDto);
    Company toEntity(UpdateCompanyDto updateCompanyDto);
}
