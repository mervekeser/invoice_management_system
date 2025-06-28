package dev.mervekeser.invoice_management_system.controllers;

import dev.mervekeser.invoice_management_system.domain.dtos.company.CompanyResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.CreateCompanyDto;
import dev.mervekeser.invoice_management_system.domain.dtos.company.UpdateCompanyDto;
import dev.mervekeser.invoice_management_system.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyResponseDto> createCompany(CreateCompanyDto createCompanyDto){
        CompanyResponseDto savedCompany = companyService.createCompany(createCompanyDto);

        return new ResponseEntity<>(
                savedCompany,
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<CompanyResponseDto> updateCompany(UpdateCompanyDto updateCompanyDto, Long id){
        CompanyResponseDto updatedCompany = companyService.updateCompany(updateCompanyDto, id);

        return new ResponseEntity<>(
                updatedCompany,
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CompanyResponseDto> getCompany(@PathVariable Long id){
        CompanyResponseDto getCompanyById = companyService.getCompanyById(id);

        return ResponseEntity.ok(getCompanyById);
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponseDto>> getAllCompanies(){
        List<CompanyResponseDto> companies = companyService.getAllCompanies();

        return ResponseEntity.ok(companies);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<CompanyResponseDto> deleteCompany(@PathVariable Long id){
        CompanyResponseDto deletedCompany = companyService.deleteCompanyById(id);

        return ResponseEntity.ok(deletedCompany);
    }
}
