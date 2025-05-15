package com.example.library.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents an Author entity in the Library Management System.
 * An Author is a person who has written one or more books.
 */
@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    /**
     * Unique identifier for the author.
     * Auto-generated primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Full name of the author.
     * Cannot be null.
     */
    @Column(nullable = false)
    private String fullName;

    /**
     * Date of birth of the author.
     * Optional field.
     */
    private LocalDate birthDate;

    /**
     * Short biography of the author.
     * Optional field.
     */
    @Column(length = 2000)
    private String biography;

    public Author(String biography, LocalDate birthDate, String fullName) {
        this.biography = biography;
        this.birthDate = birthDate;
        this.fullName = fullName;
    }

    public Author(String fullName) {
        this.fullName = fullName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    // equals() and hashCode() are essential for comparing Author objects

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(fullName, author.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }

    // toString() provides a readable representation of the object

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", biography='" + (biography != null ? biography.substring(0, Math.min(biography.length(), 50)) + "..." : "N/A") + '\'' +
                '}';
    }
}
