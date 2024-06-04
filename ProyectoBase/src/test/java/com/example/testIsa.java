package com.example;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

public class testIsa {

    @Test
    void name(){


    }

    void insertData(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();



        session.getTransaction().commit();
        session.close();

    }
}
