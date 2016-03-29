package com.infskills.data;


import com.infskills.data.entities.Bank;
import org.hibernate.Transaction;
import com.infskills.data.entities.User;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        setBank();

    }

    private static Date getMyBirthday(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1984);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DATE, 19);
        return calendar.getTime();
    }

    public static void setBank(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Transaction transaction = session.beginTransaction();
            Bank bank = new Bank();

            bank.setName("Federal Bank");
            bank.setAddressLine1("33 Wall Ave");
            bank.setAddressLine2("Suite 202");
            bank.setCity("New York");
            bank.setState("NY");
            bank.setZipCode("27914");
            bank.setCreatedBy("Jon D");
            bank.setCreatedDate(new Date());
            bank.setLastUpdatedBy("Jon D");
            bank.setLastUpdatedDate(new Date());
            bank.setInternational(false);

            bank.getContacts().add("Joe");
            bank.getContacts().add("Mary");

            session.save(bank);

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }


    }


    public static void setUser(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setBirthDate(getMyBirthday());
        user.setCreatedDate(new Date());
        user.setCreatedBy("jon");
        user.setEmailAddress("jd@test.com");
        user.setFirstName("ya");
        user.setLastName("test");
        user.setLastUpdateBy("jon");
        user.setLastUpdateDate(new Date());

        session.save(user);
        session.getTransaction().commit();

        session.refresh(user);

        System.out.println(user.getAge());

        /*session.beginTransaction();
        User dbUser = (User) session.get(User.class, user.getUserId());
        dbUser.setFirstName("New guy");
        session.getTransaction().commit();*/

        session.close();
    }
}
