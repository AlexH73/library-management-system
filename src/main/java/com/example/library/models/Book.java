package com.example.library.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a Book entity in the Library Management System.
 * A Book is written by an Author and can be borrowed by Readers.
 */
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    /**
     * Unique identifier for the book.
     * Auto-generated primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title of the book.
     * Cannot be null.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Short description or annotation of the book.
     * Optional field.
     */
    @Column(length = 2000)
    private String description;

    /**
     * Date when the book was published.
     * Optional field.
     */
    private LocalDate publicationDate;

    /**
     * International Standard Book Number.
     * Should be unique.
     */
    @Column(unique = true)
    private String isbn;

    /**
     * Many books can be written by one author.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(String title, LocalDate publicationDate, String isbn, String description, Author author) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.description = description;
        this.author = author;
    }

    public Book(Author author, String title) {
        this.author = author;
        this.title = title;
    }

    // equals() and hashCode() based on id and isbn (unique identifiers)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn);
    }

    // toString() with key information

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", isbn='" + isbn + '\'' +
                ", author=" + (author != null ? author.getFullName() : "N/A") +
                '}';
    }
}
