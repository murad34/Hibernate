package org.example.relations.OneToMany_bi;

import org.example.relations.OneToMany_bi.entity.Department;
import org.example.relations.OneToMany_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Insert {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            Department department = new Department("IT", 500, 1500);
            Employee employee1 = new Employee("Murad", "Mehdiyev", 800);
            Employee employee2 = new Employee("Revan", "Mehdiyev", 900);
            Employee employee3 = new Employee("Nihad", "Asgerli", 1000);

            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);
            department.addEmployeeToDepartment(employee3);

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
