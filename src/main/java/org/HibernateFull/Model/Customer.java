package org.HibernateFull.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.HibernateFull.Model.enums.PersonType;

import java.util.UUID;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NonNull
    private PersonType type;

    @Column(name = "adress")
    @NonNull
    private String adress;

    @Column(name = "phone_number")
    @NonNull
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bank_details_id", referencedColumnName = "id")
    private BankDetails bankDetails;
}
