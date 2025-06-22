package dev.mervekeser.invoice_management_system.mappers;

import dev.mervekeser.invoice_management_system.domain.dtos.product.CreateProductDto;
import dev.mervekeser.invoice_management_system.domain.dtos.product.ProductResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.product.UpdateProductDto;
import dev.mervekeser.invoice_management_system.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductResponseDto toDto(Product product);
    Product toEntity(CreateProductDto createProductDto);
    Product toEntity(UpdateProductDto updateProductDto);
}
