package dev.mervekeser.invoice_management_system.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity{
    private String description;
    private int quantity;
    private double unitPrice;
    private double taxRate;

    @OneToMany(mappedBy = "product")
    private List<Invoice> invoices = new ArrayList<>();
}
