package com.sanchez.test.Criteria;

import com.sanchez.jardineriahibernate.HibernateUtil;
import com.sanchez.jardineriahibernate.model.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class CriteriaCustomerOrderTest {

    @Test
    void findByAll(){

        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<CustomerOrder> criteriaQuery = builder.createQuery(CustomerOrder.class);

        JpaRoot<CustomerOrder> root = criteriaQuery.from(CustomerOrder.class);
        criteriaQuery.select(root);

        var co = session.createQuery(criteriaQuery).getResultList();
        co.forEach(System.out::println);
    }
    @Test
    void findById(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<CustomerOrder> criteriaQuery = builder.createQuery(CustomerOrder.class);

        JpaRoot<CustomerOrder> root = criteriaQuery.from(CustomerOrder.class);
        criteriaQuery.select(root).where(builder.equal(root.get("orderCode"), 1));

        var co = session.createQuery(criteriaQuery).getSingleResult();
        System.out.println(co);
        session.close();
    }
    @Test
    void findLike(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<CustomerOrder> criteriaQuery = builder.createQuery(CustomerOrder.class);

        JpaRoot<CustomerOrder> root = criteriaQuery.from(CustomerOrder.class);
        criteriaQuery.select(root).where(builder.like(root.get("state"), "%eso"));

        var co = session.createQuery(criteriaQuery).getResultList();
        co.forEach(System.out::println);

    }
    @Test
    void findByGreatherThan(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<CustomerOrder> criteriaQuery = builder.createQuery(CustomerOrder.class);

        JpaRoot<CustomerOrder> root = criteriaQuery.from(CustomerOrder.class);
        criteriaQuery.select(root).where(builder.greaterThanOrEqualTo(root.get("expectedOrderDate"), LocalDate.of(2022, 1, 1)));

        var co = session.createQuery(criteriaQuery).getResultList();
        co.forEach(System.out::println);

    }
    @Test
    void findBetween(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<CustomerOrder> criteriaQuery = builder.createQuery(CustomerOrder.class);

        JpaRoot<CustomerOrder> root = criteriaQuery.from(CustomerOrder.class);
        criteriaQuery.select(root).where(builder.between(root.get("orderDate"),
                                        LocalDate.of(1999,1,1),
                                        LocalDate.of(2021, 12, 12)));
        var co = session.createQuery(criteriaQuery).getResultList();
        co.forEach(System.out::println);
    }
    @Test
    void findByMultipleWhere(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<CustomerOrder> criteriaQuery = builder.createQuery(CustomerOrder.class);

        JpaRoot<CustomerOrder> root = criteriaQuery.from(CustomerOrder.class);
        var date = builder.greaterThanOrEqualTo(root.get("orderDate"), LocalDate.of(2023, 1, 1));
        var status = builder.equal(root.get("state"), "Completado");

        criteriaQuery.select(root).where(builder.and(date,status));
        var co = session.createQuery(criteriaQuery).getResultList();
        co.forEach(System.out::println);
    }
    @Test
    void multipleSelect(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(Object[].class);

        JpaRoot<CustomerOrder> root = criteriaQuery.from(CustomerOrder.class);
        criteriaQuery.multiselect(root.get("orderDate"),
                                root.get("state"));

        List<Object[]> results = session.createQuery(criteriaQuery).getResultList();

        for(Object[] result : results) {
            System.out.println("Title: " + result[0] + " Price: " + result[1]);
        }
    }
    void createData(){
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CustomerOrder customerOrder1 = new CustomerOrder(LocalDate.of(1999,1,1), LocalDate.of(2000, 2, 3), LocalDate.of(2024, 3, 4), "En proceso", "Comentarios de la orden 1", 101);
        CustomerOrder customerOrder2 = new CustomerOrder(LocalDate.of(1900, 1, 2), LocalDate.of(1999, 2, 3), "En proceso", 102);
        CustomerOrder customerOrder4 = new CustomerOrder(LocalDate.of(2023, 8, 10), LocalDate.of(2023, 9, 18), LocalDate.of(2023, 10, 25), "Completado", "Comentarios de la orden 4", 104);
        CustomerOrder customerOrder5 = new CustomerOrder(LocalDate.of(2021, 12, 1), LocalDate.of(2022, 1, 5), "En proceso", 105);
        CustomerOrder customerOrder3 = new CustomerOrder(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 9, 18), LocalDate.of(2023, 10, 25), "Completado", "Comentarios de la orden 4", 104);

        session.persist(customerOrder1);
        session.persist(customerOrder2);
        session.persist(customerOrder3);
        session.persist(customerOrder4);
        session.persist(customerOrder5);

        session.getTransaction().commit();

        session.close();


    }
}
