package dev.mervekeser.invoice_management_system.services.impl;

import dev.mervekeser.invoice_management_system.common.exception.DataNotFoundException;
import dev.mervekeser.invoice_management_system.common.exception.ErrorMessage;
import dev.mervekeser.invoice_management_system.common.exception.type.MessageType;
import dev.mervekeser.invoice_management_system.domain.dtos.company.CompanyResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.CreateCompanyDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.UpdateCompanyDto;
import dev.mervekeser.invoice_management_system.domain.entities.Company;
import dev.mervekeser.invoice_management_system.domain.entities.User;
import dev.mervekeser.invoice_management_system.mappers.CompanyMapper;
import dev.mervekeser.invoice_management_system.repositories.CompanyRepository;
import dev.mervekeser.invoice_management_system.services.CompanyService;
import dev.mervekeser.invoice_management_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UserService userService;

    @Override
    public CompanyResponseDto createCompany(CreateCompanyDto createCompanyDto) {
        Company company = companyMapper.toEntity(createCompanyDto);
        User user = userService.getUser(createCompanyDto.userId());

        if(user == null){
            throw new DataNotFoundException(new ErrorMessage(MessageType.USER_NOT_FOUND, createCompanyDto.userId().toString()));
        }

        company.setUser(user);
        companyRepository.save(company);
        return companyMapper.toDto(company);
    }

    @Override
    public CompanyResponseDto updateCompany(UpdateCompanyDto updateCompanyDto, Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException(new ErrorMessage(MessageType.COMPANY_NOT_FOUND, id.toString())));

        company.setName(updateCompanyDto.name());
        company.setPhone(updateCompanyDto.phone());
        company.setEmail(updateCompanyDto.email());
        company.setTaxNumber(updateCompanyDto.taxNumber());

        User user = userService.getUser(updateCompanyDto.userId());

        if(user == null){
            throw new DataNotFoundException(new ErrorMessage(MessageType.USER_NOT_FOUND, updateCompanyDto.userId().toString()));
        }

        company.setUser(user);
        companyRepository.save(company);

        return companyMapper.toDto(company);
    }

    @Override
    public CompanyResponseDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException(
                        new ErrorMessage(MessageType.COMPANY_NOT_FOUND, id.toString())
                ));

        return companyMapper.toDto(company);
    }

    @Override
    public List<CompanyResponseDto> getAllCompanies() {
        List<Company> allCompanies = companyRepository.findAll();

        List<CompanyResponseDto> companies = allCompanies.stream()
                .map(companyMapper::toDto)
                .toList();
        return companies;
    }

    @Override
    public CompanyResponseDto deleteCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(
                        new ErrorMessage(MessageType.COMPANY_NOT_FOUND, id.toString())
                ));
        companyRepository.delete(company);

        return companyMapper.toDto(company);
    }

    @Override
    public Company getCompany(Long id){
        Company company = companyRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(
                        new ErrorMessage(MessageType.COMPANY_NOT_FOUND, id.toString())
                ));

        return company;
    }
}
