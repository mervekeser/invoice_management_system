package dev.mervekeser.invoice_management_system.services;

import dev.mervekeser.invoice_management_system.domain.dtos.company.CompanyResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.CreateCompanyDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.UpdateCompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyResponseDto createCompany(CreateCompanyDto createCompanyDto);
    CompanyResponseDto updateCompany(UpdateCompanyDto updateCompanyDto);
    CompanyResponseDto getCompanyById(Long id);
    List<CompanyResponseDto> getAllCompanies();
    CompanyResponseDto deleteCompanyById(Long id);
}
