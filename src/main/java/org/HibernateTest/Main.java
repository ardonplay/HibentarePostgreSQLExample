package org.HibernateTest;

import org.HibernateTest.Model.Accounts;
import org.hibernate.Session;

public class Main {

  public static void main(String[] args) {

    int const test 
    Session session = HibernateUtil.getSessionFactory().openSession();

    for (Accounts accounts : new AccountsHelper().getAccountsList()) {
        System.out.println("Персона нонграда: " + accounts.getName());
    }



  }
}