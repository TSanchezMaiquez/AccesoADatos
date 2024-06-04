package com.example;

import com.example.model.Borrow;
import com.example.model.House;
import com.example.model.Vehicle;
import org.junit.jupiter.api.Test;

public class AnyTest {

    @Test
    void any() {

        insertData();

        var session = HibernateUtil.getSessionFactory().openSession();

        var borrow1 = session.find(Borrow.class, 1L);
        var borrow3 = session.find(Borrow.class, 3L);
        //getName devuelve lo que hallamos querido incluir en el metodo
        //En casa le hemos puesto la localizacion, lo cual no tiene mucho sentido
        //System.out.println(borrow1.getItem().getName()); // house
        System.out.println(borrow1); // house
        //Aqui llamamos al metodo getItem() para que lo convierta al tipo Item y asi poder
        //acceder al metodo getName
        System.out.println(borrow3.getItem().getName()); // vehicle
        System.out.println(borrow3); // vehicle

        Vehicle vehicle = (Vehicle) borrow3.getItem();
        System.out.println(vehicle);
    }

    void insertData(){

        var session = HibernateUtil.getSessionFactory().openSession();


        var house1 = new House(null, "madrid", 150000.0);
        var house2 = new House(null, "barcelona", 200000.0);

        var vehicle1 = new Vehicle(null, "ford", "mondeo", 20000.0);
        var vehicle2 = new Vehicle(null, "toyota", "prius", 10000.0);

        session.beginTransaction();

        session.persist(house1);
        session.persist(house2);

        session.persist(vehicle1);
        session.persist(vehicle2);

        var borrow1 = new Borrow("concept1", house1);
        var borrow2 = new Borrow("concept2", house2);
        var borrow3 = new Borrow("concept3", vehicle1);
        var borrow4 = new Borrow("concept4", vehicle2);

        session.persist(borrow1);
        session.persist(borrow2);
        session.persist(borrow3);
        session.persist(borrow4);

        session.getTransaction().commit();
    }
}