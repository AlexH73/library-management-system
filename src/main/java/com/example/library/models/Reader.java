package com.example.library.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a Reader entity in the Library Management System.
 * A Reader is a person who can borrow books.
 */
@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reader {

    /**
     * Unique identifier for the reader.
     * Auto-generated primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Full name of the reader.
     * Cannot be null.
     */
    @Column(nullable = false)
    private String fullName;

    /**
     * Reader's email address.
     * Should be unique and not null.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Date of birth of the reader.
     * Optional field.
     */
    private LocalDate dateOfBirth;

    /**
     * Phone number of the reader.
     * Optional field.
     */
    private String phoneNumber;

    public Reader(LocalDate dateOfBirth, String email, String fullName, String phoneNumber) {
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public Reader(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // equals() and hashCode() based on id and email (unique identifiers)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reader)) return false;
        Reader reader = (Reader) o;
        return Objects.equals(id, reader.id) &&
                Objects.equals(email, reader.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    // toString() with key information

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
