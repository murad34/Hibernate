package org.example.relations.OneToMany_bi;

import org.example.relations.OneToMany_bi.entity.Department;
import org.example.relations.OneToMany_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
