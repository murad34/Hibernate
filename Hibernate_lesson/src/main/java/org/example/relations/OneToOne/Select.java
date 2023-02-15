package org.example.relations.OneToOne;

import org.example.relations.OneToOne.entity.Detail;
import org.example.relations.OneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Select {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();

        Session session = null;

        try {

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class, 3);
            System.out.println(employee + " " + employee.getEmpDetails());

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
