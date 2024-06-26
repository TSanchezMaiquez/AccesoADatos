package com.example;

import com.example.model.Address;
import com.example.model.Author;
import com.example.model.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class OneToManyTest {
    /*Es recomendable tener la asociacion ManyToOne si creamos la asociacion OneToMany para que la busqueda sea
    * bidireccional. Es de fetch LAZY por defecto*/
    @Test
    void oneToMany() {

        insertData();
        var session = HibernateUtil.getSessionFactory().openSession();

        var author = session.find(Author.class, 1L);
        var author2 = session.find(Author.class, 2L);

        System.out.println(author.getBooks());
        System.out.println(author2.getBooks());
    }

    void insertData(){

        var session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        var author1 = new Author("author1", "autor1@gmail.com",
                LocalDate.of(1990,1,1));

        var author2 = new Author("author2", "autor2@gmail.com",
                LocalDate.of(1990,1,1));


        var address1 = new Address("street1", "city1", "country1");
        var address2 = new Address("street2", "city2", "country2");

        author1.setAddress(address1);
        author2.setAddress(address2);


        session.persist(address1);
        session.persist(address2);

        session.persist(author1);
        session.persist(author2);

        var book1 = new Book("book1", author1, 19.99, 450,true);
        var book2 = new Book("book1", author1, 19.99, 450,true);
        var book3 = new Book("book1", author1, 19.99, 450,true);
        var book4 = new Book("book1", author2, 19.99, 450,true);

        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);

        session.getTransaction().commit();

    }
}


