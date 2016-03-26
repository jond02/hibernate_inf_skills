package com.infskills.data;


import org.hibernate.Session;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.close();
    }
}
