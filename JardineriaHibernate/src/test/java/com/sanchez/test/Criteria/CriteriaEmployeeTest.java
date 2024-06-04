package com.sanchez.test.Criteria;

import com.sanchez.jardineriahibernate.HibernateUtil;
import com.sanchez.jardineriahibernate.model.CustomerOrder;
import com.sanchez.jardineriahibernate.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class CriteriaEmployeeTest {
    @Test
    void findByAll(){

        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(Employee.class);

        var root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);

        var all = session.createQuery(criteriaQuery).getResultList();
        all.forEach(System.out::println);
    }

    @Test
    void findById(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(Employee.class);

        var root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root).where(builder.equal(root.get("employeeCode"), 1));

        var co = session.createQuery(criteriaQuery).getSingleResult();
        System.out.println(co);
        session.close();
    }

    @Test
    void findLike(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(Employee.class);

        var root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root).where(builder.like(root.get("name"), "%ploy%"));

        var rootLike = session.createQuery(criteriaQuery).getResultList();
        rootLike.forEach(System.out::println);

    }
    @Test
    void findByGreatherThan(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(Employee.class);

        var root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root).where(builder.greaterThanOrEqualTo(root.get("managerCode"),3 ));

        var co = session.createQuery(criteriaQuery).getResultList();
        co.forEach(System.out::println);

    }
    @Test
    void findBetween(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(Employee.class);

        var root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root).where(builder.between(root.get("employeeCode"),
               2, 4));
        var co = session.createQuery(criteriaQuery).getResultList();
        co.forEach(System.out::println);
    }
    @Test
    void findByMultipleWhere(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(Employee.class);

        var root = criteriaQuery.from(Employee.class);
        var mc = builder.greaterThanOrEqualTo(root.get("managerCode"), 2);
        var name = builder.equal(root.get("name"), "employee4");

        criteriaQuery.select(root).where(builder.and(mc,name));
        var co = session.createQuery(criteriaQuery).getResultList();
        co.forEach(System.out::println);
    }
    @Test
    void multipleSelect(){
        createData();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(Object[].class);

        var root = criteriaQuery.from(Employee.class);
        criteriaQuery.multiselect(root.get("name"),
                root.get("extenxion"));

        List<Object[]> results = session.createQuery(criteriaQuery).getResultList();

        for(Object[] result : results) {
            System.out.println("Name: " + result[0] + " Extension: " + result[1]);
        }
    }
    void createData () {

        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //String name, String surname1, String extenxion, String email, String officeCod
        var employee1 = new Employee("employee1", "ape", "1234", "anasf", "4");
        //String name, String surname1, String surname2, String extenxion, String email, String officeCod, Employee managerCode, String position
        var employee2 = new Employee("employee2", "ap1", "sur2", "234", "asdfasdf", "asdf", 1, "123");
        var employee3 = new Employee("employee3", "ap2", "sur3", "345", "qwerqwer", "qwer", 2, "456");
        var employee4 = new Employee("employee4", "ap3", "sur4", "456", "zxcvzxcv", "zxcv", 6, "789");
        var employee5 = new Employee("employee5", "ap4", "sur5", "567", "uiopuiop", "uiop", 3, "987");
        var employee6 = new Employee("employee6", "ap5", "sur6", "678", "tyuityui", "tyui", 5, "654");

        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);
        session.persist(employee4);
        session.persist(employee5);
        session.persist(employee6);

        session.getTransaction().commit();

        session.close();
    }
}
