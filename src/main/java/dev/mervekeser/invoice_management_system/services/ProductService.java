package dev.mervekeser.invoice_management_system.services;

import dev.mervekeser.invoice_management_system.domain.dtos.product.CreateProductDto;
import dev.mervekeser.invoice_management_system.domain.dtos.product.ProductResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.product.UpdateProductDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(CreateProductDto createProductDto);
    ProductResponseDto updateProduct(UpdateProductDto updateProductDto, Long id);
    ProductResponseDto getProductById(Long id);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto deleteProductById(Long id);
}
