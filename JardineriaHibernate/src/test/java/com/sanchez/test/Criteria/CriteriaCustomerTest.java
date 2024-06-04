package com.sanchez.test.Criteria;

import com.sanchez.jardineriahibernate.HibernateUtil;
import com.sanchez.jardineriahibernate.model.Customer;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class CriteriaCustomerTest {

    @Test
    void findAll(){
        createDate();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);

        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root);

        var customers = session.createQuery(criteriaQuery).list();
        customers.forEach(System.out::println);
    }

    @Test
    void findById(){
        createDate();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);

        JpaRoot<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root).where(builder.equal(root.get("customerCode"), 1));

        var customer = session.createQuery(criteriaQuery).getSingleResult();
        System.out.println(customer);
        }
@Test
void findCountryLike(){

    createDate();
    var session = HibernateUtil.getSessionFactory().openSession();

    HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
    JpaCriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);

    JpaRoot<Customer> root = criteriaQuery.from(Customer.class);
    criteriaQuery.select(root).where(builder.like(root.get("postCode"), "%321"));

    var customers = session.createQuery(criteriaQuery).getResultList();
    customers.forEach(System.out::println);

    session.close();
}
    @Test
    void findByEmployeeCodeGreaterThan(){
        createDate();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);

        JpaRoot<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root).where(builder.greaterThanOrEqualTo(root.get("employeeCode"), 103));

        var customers = session.createQuery(criteriaQuery).getResultList();
        customers.forEach(System.out::println);
        session.close();
    }
    @Test
    void findBetween(){
        createDate();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);

        JpaRoot<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root).where(builder.between(root.get("employeeCode"), 100, 104));

        var customers = session.createQuery(criteriaQuery).getResultList();
        customers.forEach(System.out::println);
    }
    @Test
    void findByMultipleWhere (){
        createDate();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);

        JpaRoot<Customer> root = criteriaQuery.from(Customer.class);
        var country = builder.equal(root.get("country"), "Pais3");
        var employeeCode = builder.greaterThanOrEqualTo(root.get("employeeCode"), 104);

        criteriaQuery.select(root).where(builder.and(country, employeeCode));

        var customers = session.createQuery(criteriaQuery).getResultList();
        customers.forEach(System.out::println);

    }
    @Test
    void findByMultipleSelect (){
        createDate();
        var session = HibernateUtil.getSessionFactory().openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        var criteriaQuery = builder.createQuery(Object[].class);

        JpaRoot<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.multiselect(root.get("customerName"),
                                  root.get("contactName"));

        List<Object[]> results = session.createQuery(criteriaQuery).getResultList();
        for(Object[] result : results) {
            System.out.println("CustomerName: " + result[0] + " ContactName: " + result[1]);
        }

        session.close();

    }
    void createDate(){

        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //String name, String surname1, String extenxion, String email, String officeCod
        var customer1 = new Customer("NombreCliente1", "Contacto1", "ApellidoContacto1",
                "123456789", "123456789", "Direccion1", "Direccion2", "Ciudad1", "Region1",
                "Pais1", "12321", 100, new BigDecimal("10000.00"));


        var customer2 = new Customer("NombreCliente2", "987654321", "987694321",
                "OtraDireccion", "OtraCiudad");

        var customer3 = new Customer("NombreCliente3", "Contacto3", "ApellidoContacto3",
                "987654321", "987654321", "OtraDireccion3", "OtraDireccion4", "Ciudad3", "Region3",
                "Pais3", "54321", 103, new BigDecimal("15000.00"));


        var customer4 = new Customer("NombreCliente4", "456789012", "456779012",
                "Direccion4", "Ciudad4");

        var customer5 = new Customer("NombreCliente5", "Contacto5", "ApellidoContacto3",
                "987654321", "987654621", "OtraDireccion3", "OtraDireccion4", "Ciudad3", "Region3",
                "Pais3", "54321", 104, new BigDecimal("13000.00"));

        var customer6 = new Customer("NombreCliente6", "Contacto6", "ApellidoContacto3",
                "987654321", "987654621", "OtraDireccion3", "OtraDireccion4", "Ciudad3", "Region3",
                "Pais3", "54321", 105, new BigDecimal("13000.00"));

        session.persist(customer1);
        session.persist(customer2);
        session.persist(customer3);
        session.persist(customer4);
        session.persist(customer5);
        session.persist(customer6);


        session.getTransaction().commit();

        session.close();
    }
}
