package org.HibernateFull;

import org.HibernateFull.Model.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Person> persons= HibernateUtil.getEntries(Person.class);

        System.out.println(persons);

        //HibernateUtil.deleteEntry(persons);

        //Person person = new Person("Vladimir", "Moshchuk", "375298277252");
        //HibernateUtil.addEntry(person);
        System.out.println(HibernateUtil.getFreeID(Person.class));


    }
}