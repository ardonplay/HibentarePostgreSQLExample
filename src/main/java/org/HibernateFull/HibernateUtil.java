package org.HibernateFull;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    @Getter
    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

    }

}
//
//    public static <T> List<T> getEntries(Class<T> entityClass) {
//        List<T> entries = null;
//        try (Session session = sessionFactory.getCurrentSession()) {
//            try {
//                session.beginTransaction();
//                CriteriaBuilder cb = session.getCriteriaBuilder();
//
//                CriteriaQuery<T> cq = cb.createQuery(entityClass);
//
//                Root<T> root = cq.from(entityClass);
//
//                cq.select(root);
//
//                Query query = session.createQuery(cq);
//
//                entries = query.getResultList();
//
//                session.getTransaction().commit();
//            } finally {
//                session.close();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getLocalizedMessage());
//        }
//        return entries;
//    }
//
//    public static void addEntry(Object entry){
//        try(Session session = getSessionFactory().getCurrentSession()){
//            try {
//                session.beginTransaction();
//                session.persist(entry);
//                session.getTransaction().commit();
//            }finally {
//                session.close();
//            }
//        }
//    }
//
//    public static <T>  void addEntry(List<T> entries){
//        try(Session session = getSessionFactory().getCurrentSession()){
//            try {
//                session.beginTransaction();
//                for (T entry:entries) {
//                  session.persist(entry);
//                }
//                session.getTransaction().commit();
//            }finally {
//                session.close();
//            }
//        }
//    }
//    public static void deleteEntry(Object entry){
//        try(Session session = getSessionFactory().getCurrentSession()){
//            try {
//                session.beginTransaction();
//                session.remove(entry);
//                session.getTransaction().commit();
//            }finally {
//                session.close();
//            }
//        }
//        catch (Exception e){
//            throw e;
//        }
//    }
//
//    public static <T> void deleteEntry(List<T> entries){
//        try(Session session = getSessionFactory().getCurrentSession()){
//            try {
//                session.beginTransaction();
//                for (T entry: entries) {
//                    session.remove(entry);
//                }
//                session.getTransaction().commit();
//            }finally {
//                session.close();
//            }
//        }
//        catch (Exception e){
//            throw e;
//        }
//    }
//
//    public static <T> int getFreeID(Class<T> abstractEntity) throws Exception {
//       int prevID;
//       if(abstractEntity.equals(Person.class)){
//           prevID = getFreePersonID();
//       }
//       else if(abstractEntity.equals(Card.class)){
//           prevID = getFreeCardID();
//       }
//       else {
//           throw new Exception("You are dolbaeb, you need use only Person or Card class...");
//       }
//        return prevID;
//
//    }
//    private static int getFreeCardID(){
//        List<Card> entries = getEntries(Card.class);
//        int prevID = 0;
//        for (Card entry: entries) {
//            if(prevID+1 != entry.getId()){
//                break;
//            }
//            else{
//                prevID = entry.getId();
//            }
//        }
//        return prevID +1;
//
//    }
//    private static int getFreePersonID(){
//        List<Person> entries = getEntries(Person.class);
//        int prevID = 0;
//        for (Person entry: entries) {
//            if(prevID+1 != entry.getId()){
//                break;
//            }
//            else{
//                prevID = entry.getId();
//            }
//        }
//        return prevID +1;
//    }