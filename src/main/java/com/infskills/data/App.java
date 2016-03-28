package com.infskills.data;


import com.infskills.data.entities.User;
import org.hibernate.Session;

import java.util.Date;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("jon");
        user.setEmailAddress("jd@test.com");
        user.setFirstName("wilson");
        user.setLastName("test");
        user.setLastUpdateBy("jon");
        user.setLastUpdateDate(new Date());

        session.save(user);
        session.getTransaction().commit();

        session.close();
    }
}
