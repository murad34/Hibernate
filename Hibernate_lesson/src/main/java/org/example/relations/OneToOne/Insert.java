package org.example.relations.OneToOne;

import org.example.relations.OneToOne.entity.Detail;
import org.example.relations.OneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Insert {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();

        try {

            Session session = sessionFactory.getCurrentSession();

            Employee employee = new Employee("Nikolay", "Tregulov", "Designer", 1500);
            Detail detail = new Detail("London", "999999999", "nikolay_london@gmail.com");

            employee.setEmpDetails(detail);
//            detail.setEmployee(employee);

            session.beginTransaction();
//            session.save(employee);
            session.save(detail);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
