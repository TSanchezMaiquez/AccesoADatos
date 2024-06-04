package com.example;

import com.example.model.Avion;
import jakarta.persistence.criteria.Root;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.junit.jupiter.api.Test;

public class TestCriteria {

    @Test
    void findAll(){

        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<Avion> criteriaQuery = builder.createQuery(Avion.class);

        Root<Avion> root = criteriaQuery.from(Avion.class);
        criteriaQuery.select(root);

        var aviones = session.createQuery(criteriaQuery).list();
        //Para que este test los traiga todos juntos y no de fallo hay que ponerle EAGER a la
        //asociacion que hay con piloto en la entity tipo y cerrar la session en este punto
        //session.close();

        aviones.forEach(System.out::println);
    }
}
