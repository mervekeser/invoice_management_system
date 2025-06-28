package dev.mervekeser.invoice_management_system.controllers;

import dev.mervekeser.invoice_management_system.domain.dtos.product.CreateProductDto;
import dev.mervekeser.invoice_management_system.domain.dtos.product.ProductResponseDto;
import dev.mervekeser.invoice_management_system.domain.dtos.product.UpdateProductDto;
import dev.mervekeser.invoice_management_system.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody CreateProductDto createProductDto){
        ProductResponseDto savedProduct = productService.createProduct(createProductDto);

        return new ResponseEntity<>(
                savedProduct,
                HttpStatus.CREATED
        );

    }

    @PutMapping(path = "{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@Valid @RequestBody UpdateProductDto updateProductDto, Long id){
        ProductResponseDto updatedProduct = productService.updateProduct(updateProductDto, id);

        return new ResponseEntity<>(
                updatedProduct,
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id){
        ProductResponseDto getProductById = productService.getProductById(id);

        return ResponseEntity.ok(getProductById);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<ProductResponseDto> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable Long id){
        ProductResponseDto deletedProduct = productService.deleteProductById(id);

        return ResponseEntity.ok(deletedProduct);
    }
}
