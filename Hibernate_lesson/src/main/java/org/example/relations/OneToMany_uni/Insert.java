package org.example.relations.OneToMany_uni;

import org.example.relations.OneToMany_uni.entity.Department;
import org.example.relations.OneToMany_uni.entity.Employee;
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

            Department department = new Department("HR", 400, 1200);
            Employee employee1 = new Employee("Ivan", "Ivanov", 660);
            Employee employee2 = new Employee("Mariya", "Alekseevna", 770);
            Employee employee3 = new Employee("Victoriya", "Korisheva", 800);

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
