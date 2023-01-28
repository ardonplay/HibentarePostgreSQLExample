package org.HibernateTest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "accounts")
public class Accounts implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;

  private String Name;
}
