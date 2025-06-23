package dev.mervekeser.invoice_management_system.repositories;

import dev.mervekeser.invoice_management_system.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findByContent(String content);
}
