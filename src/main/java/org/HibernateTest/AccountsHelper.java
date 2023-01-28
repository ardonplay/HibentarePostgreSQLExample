package org.HibernateTest;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.HibernateTest.Model.Accounts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountsHelper {

  private final SessionFactory sessionFactory;

  public AccountsHelper() {
    sessionFactory = HibernateUtil.getSessionFactory();
  }

  public List<Accounts> getAccountsList(){
    Session session= sessionFactory.openSession();

    session.get(Accounts.class, 1);

    CriteriaBuilder cb = session.getCriteriaBuilder();

    CriteriaQuery<Accounts> cq = cb.createQuery(Accounts.class);

    Root<Accounts> root = cq.from(Accounts.class);

    cq.select(root);

    Query query = session.createQuery(cq);

    List<Accounts> personList = query.getResultList();

    session.close();

    return personList;

  }

  public Accounts getPerson(String name) {
    return  null;
  }
}
