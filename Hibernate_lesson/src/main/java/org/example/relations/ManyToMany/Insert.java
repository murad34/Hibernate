package org.example.relations.ManyToMany;

import org.example.relations.ManyToMany.entity.Child;
import org.example.relations.ManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Insert {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class).addAnnotatedClass(Section.class).buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            Section section1 = new Section("Football");
            Child child1 = new Child("Murad",7);
            Child child2 = new Child("Tural",5);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);

            Section section2 = new Section("Swimming");
            Child child3 = new Child("Revan",6);
            Child child4 = new Child("Aslan",9);
            section2.addChildToSection(child3);
            section2.addChildToSection(child4);

            session.beginTransaction();
            session.persist(section1);
            session.persist(section2);
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
