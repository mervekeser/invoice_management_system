package dev.mervekeser.invoice_management_system.services;

import dev.mervekeser.invoice_management_system.domain.dtos.company.CompanyResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.CreateCompanyDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.UpdateCompanyDto;
import dev.mervekeser.invoice_management_system.domain.entities.Company;

import java.util.List;

public interface CompanyService {
    CompanyResponseDto createCompany(CreateCompanyDto createCompanyDto);
    CompanyResponseDto updateCompany(UpdateCompanyDto updateCompanyDto, Long id);
    CompanyResponseDto getCompanyById(Long id);
    List<CompanyResponseDto> getAllCompanies();
    CompanyResponseDto deleteCompanyById(Long id);
    Company getCompany(Long id);
}
