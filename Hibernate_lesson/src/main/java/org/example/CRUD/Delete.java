package org.example.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

//            Employee employee = session.get(Employee.class,5);
//            session.delete(employee);

            session.createQuery("delete Employee where surname = 'Ahmedov'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
