package com.example.model.maps;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    /*Relacion unilateral(no hay ManyToMany en Book), con la propiedad de Map*/
    @ManyToMany
    @JoinTable(name = "authors_books",
        joinColumns = @JoinColumn(name= "author_id"),
        inverseJoinColumns = @JoinColumn(name= "book_id"))

    /*Un map esta compuesto por la clave y el valor. El valor será el libro y como clave va a usar el
    * campo isbn de la entity Book
    *
    * author1.getBooks().put(book1.getIsbn(), book1);
    * */
    @MapKey(name = "isbn")
    private Map<String, Book> books = new HashMap<>();

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
