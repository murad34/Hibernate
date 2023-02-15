package org.example.relations.ManyToMany;

import org.example.relations.ManyToMany.entity.Child;
import org.example.relations.ManyToMany.entity.Section;
import org.example.relations.OneToMany_bi.entity.Department;
import org.example.relations.OneToMany_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Select {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class).addAnnotatedClass(Section.class).buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

//            Section section = session.get(Section.class,1);
//            System.out.println(section);
//            System.out.println(section.getChildrenList());

            Child child = session.get(Child.class, 5);
            System.out.println(child);
            System.out.println(child.getSectionList());

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
