package org.example.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Select {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 3);
//            System.out.println(employee);

//            List<Employee> emps = session.createQuery("from Employee").getResultList();

            List<Employee> emps = session.createQuery("from Employee where department = 'IT' and salary > 1100").getResultList();

            for (Employee e : emps) {
                System.out.println(e);
            }

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
