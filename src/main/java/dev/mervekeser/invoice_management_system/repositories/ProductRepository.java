package dev.mervekeser.invoice_management_system.repositories;

import dev.mervekeser.invoice_management_system.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
