package com.example.library.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Loan — сущность, описывающая факт выдачи книги читателю.
 * Содержит информацию о дате выдачи, возврате и статусе займа.
 */
@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    /**
     * Уникальный идентификатор займа.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Связь с сущностью Reader (читатель, который взял книгу).
     * Many Loans -> One Reader.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;

    /**
     * Связь с сущностью Book (книга, которая выдана).
     * Many Loans -> One Book.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    /**
     * Дата начала займа (дата выдачи книги).
     */
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;

    /**
     * Дата возврата книги (если уже вернули).
     */
    @Column(name = "return_date")
    private LocalDate returnDate;

    /**
     * Статус займа: ACTIVE, RETURNED, OVERDUE.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private LoanStatus status;

    /**
     * Перечисление статусов займа.
     */
    public enum LoanStatus {
        ACTIVE,
        RETURNED,
        OVERDUE
    }
}
