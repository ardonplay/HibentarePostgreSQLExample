package org.HibernateFull.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cards")
public class Card{
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "card_id")
    private String cardID;

    @Column(name = "balance")
    private double balance;

    @Column(name = "currency")
    private String currency;

    public Card(){}

    public Card(String cardID){
        this.cardID = cardID;
    }

    @Override
    public String toString() {
        return cardID + " Balance: " + balance + currency;
    }
}
