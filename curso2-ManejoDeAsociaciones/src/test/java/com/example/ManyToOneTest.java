package com.example;

import com.example.model.Address;
import com.example.model.Author;
import com.example.model.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ManyToOneTest {
    /*En este tipo de asociacion el fetch por defecto es EAGER, por lo que tenemos que cambiarlo a LAZY ya que
    * si tiene numchas asociaciones el registro que nos queremos traer se ralentizara la consulta.
    * Ver linea 23 de la clase BOOK*/
    @Test
    void manyToOne() {

        insertData();
        var session = HibernateUtil.getSessionFactory().openSession();

        var book1 = session.find(Book.class, 1L);
        var book3 = session.find(Book.class, 3L);

        System.out.println(book1.getAuthor());
        System.out.println(book3.getAuthor());
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
        var book3 = new Book("book1", author2, 19.99, 450,true);
        var book4 = new Book("book1", author2, 19.99, 450,true);


        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);

        session.getTransaction().commit();

    }
}
