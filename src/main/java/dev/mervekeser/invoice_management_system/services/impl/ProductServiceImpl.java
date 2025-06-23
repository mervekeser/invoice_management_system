package dev.mervekeser.invoice_management_system.services.impl;

import dev.mervekeser.invoice_management_system.common.exception.DataNotFoundException;
import dev.mervekeser.invoice_management_system.common.exception.ErrorMessage;
import dev.mervekeser.invoice_management_system.common.exception.type.MessageType;
import dev.mervekeser.invoice_management_system.domain.dtos.product.CreateProductDto;
import dev.mervekeser.invoice_management_system.domain.dtos.product.ProductResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.product.UpdateProductDto;
import dev.mervekeser.invoice_management_system.domain.entities.Product;
import dev.mervekeser.invoice_management_system.mappers.ProductMapper;
import dev.mervekeser.invoice_management_system.repositories.ProductRepository;
import dev.mervekeser.invoice_management_system.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto createProduct(CreateProductDto createProductDto) {
        Product product = productMapper.toEntity(createProductDto);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public ProductResponseDto updateProduct(UpdateProductDto updateProductDto, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.PRODUCT_NOT_FOUND, id.toString())));

        product.setDescription(updateProductDto.description());
        product.setQuantity(updateProductDto.quantity());
        product.setUnitPrice(updateProductDto.unitPrice());
        product.setTaxRate(updateProductDto.taxRate());

        Product updatedProduct = productRepository.save(product);

        return productMapper.toDto(updatedProduct);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.PRODUCT_NOT_FOUND, id.toString())));

        return productMapper.toDto(product);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductResponseDto> allProduct = products.stream()
                .map(productMapper::toDto)
                .toList();

        return allProduct;
    }

    @Override
    public ProductResponseDto deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(new ErrorMessage(MessageType.PRODUCT_NOT_FOUND, id.toString())));
        productRepository.delete(product);

        return productMapper.toDto(product);
    }

    @Override
    public Product getProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(
                        new ErrorMessage(MessageType.PRODUCT_NOT_FOUND, id.toString())
                ));

        return product;
    }
}
