package org.example.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class Insert {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            Employee employee = new Employee("Ruslan", "Ahmedov", "Operator", 500);

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println(employee);

        } finally {
            sessionFactory.close();
        }

    }

}
