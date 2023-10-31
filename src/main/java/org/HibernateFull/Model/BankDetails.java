package org.HibernateFull.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "bank_details")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    @NonNull
    private String number;

    @Column(name = "bank_name")
    @NonNull
    private String name;

    @OneToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
