package dev.mervekeser.invoice_management_system.repositories;

import dev.mervekeser.invoice_management_system.domain.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
