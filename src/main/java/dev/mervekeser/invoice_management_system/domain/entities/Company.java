package dev.mervekeser.invoice_management_system.domain.entities;

import jakarta.persistence.*;
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
@Table(name = "companies")
public class Company extends BaseEntity{
    private String name;
    private String phone;
    private String email;
    private String taxNumber;

    @OneToMany(mappedBy = "company")
    private List<Invoice> invoices = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "company")
    private List<Address> addresses = new ArrayList<>();
}
