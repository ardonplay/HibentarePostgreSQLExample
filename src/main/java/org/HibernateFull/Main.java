package org.HibernateFull;

import org.HibernateFull.Model.BankDetails;
import org.HibernateFull.Model.Customer;
import org.HibernateFull.Model.enums.PersonType;
import org.hibernate.Session;

import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {
        Customer customer =new Customer("Aboa6t5", PersonType.INDIVIDUAL, "abobaStreetytyty", "14457478ytytyt");
        BankDetails bankDetails = new BankDetails("fghj", "fgh");
        customer.setBankDetails(bankDetails);
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            try {
                session.beginTransaction();
                Customer customer1 = session.get(Customer.class, UUID.fromString("ca2782ca-4069-4218-a196-51fc1afbd733"));
                session.remove(customer1);
                //session.persist(customer);
                session.getTransaction().commit();
            }finally {
                session.close();
            }
        }
    }
}