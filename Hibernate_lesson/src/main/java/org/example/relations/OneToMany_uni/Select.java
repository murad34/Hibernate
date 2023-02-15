package org.example.relations.OneToMany_uni;

import org.example.relations.OneToMany_uni.entity.Department;
import org.example.relations.OneToMany_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Select {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Department department = session.get(Department.class,2);
            System.out.println(department);
            System.out.println(department.getEmployeeList());

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
