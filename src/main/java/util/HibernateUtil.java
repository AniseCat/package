package util;

import PO.*;
import dao.StudentDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(AuthcodePO.class);
        config.addAnnotatedClass(UserPO.class);
        config.addAnnotatedClass(CoursePO.class);
        config.addAnnotatedClass(LecturePO.class);
        config.addAnnotatedClass(PostPO.class);
        config.addAnnotatedClass(PostitemPO.class);
        config.addAnnotatedClass(StudentPO.class);
        config.addAnnotatedClass(TeacherPO.class);
        config.addAnnotatedClass(NoticePO.class);
        config.addAnnotatedClass(SelectcoursePO.class);
        config.addAnnotatedClass(PreselectPO.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static Session getSession(){
        return getSessionFactory().getCurrentSession();
    }

}
