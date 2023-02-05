package org.HibernateFull.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "person")
public class Person{
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "phone")
  private String phone;
  @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
  private List<Card> cards;

  public Person(String firstName, String lastName, String phone){
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
  }

  public Person() {

  }

  @Override
  public String toString() {
    return  "id=" + id +
            ",\nfirstName= " + firstName + '\n' +
            "lastName= " + lastName + '\n' +
            "cards=" + cards +
            '}' + '\n';
  }
}
