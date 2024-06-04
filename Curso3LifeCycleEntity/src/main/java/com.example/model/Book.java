package com.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double price;
    @Column(name="num_pages")
    private Integer numPages;

    private boolean published;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name= "author_id")
    private Author author;

    @ManyToMany
    @JoinTable(name= "book_category",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name ="Category_id", referencedColumnName = "id"))

    private Set<Category> categories = new HashSet<>();

    public Book() {
    }

    public Book(String title, Author author, Double price, Integer numPages, boolean published) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", numPages=" + numPages +
                ", published=" + published +
                '}';
    }
}
