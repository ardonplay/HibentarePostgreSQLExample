package org.HibernateFull;

import org.HibernateFull.Model.BankDetails;
import org.HibernateFull.Model.Customer;
import org.HibernateFull.Model.enums.PersonType;
import org.hibernate.Session;

import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {
        Customer customer =new Customer("Aboa6t54354", PersonType.INDIVIDUAL, "abobaStreetytyt435", "86754975");
        BankDetails bankDetails = new BankDetails("fghghfhj", "fghhjh");
        customer.setBankDetails(bankDetails);
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            try {
                session.beginTransaction();
                session.remove(session.get(Customer.class, UUID.fromString("38aa7515-6b36-460a-9e89-90afc5aa6d16")));
                session.getTransaction().commit();
            }finally {
                session.close();
            }
        }
    }
}