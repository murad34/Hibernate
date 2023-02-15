package org.example.relations.ManyToMany;

import org.example.relations.ManyToMany.entity.Child;
import org.example.relations.ManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class).addAnnotatedClass(Section.class).buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

//            Section section = session.get(Section.class,7);
//            session.delete(section);

            Child child = session.get(Child.class, 11);
            session.delete(child);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
