package com.example.library.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Reservation — сущность, описывающая бронирование книги читателем.
 * Используется для фиксации заявок на получение книги, которая сейчас недоступна.
 */
@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    /**
     * Уникальный идентификатор бронирования.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Связь с сущностью Reader (читатель, сделавший бронирование).
     * Many Reservations -> One Reader.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;

    /**
     * Связь с сущностью Book (книга, которая забронирована).
     * Many Reservations -> One Book.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    /**
     * Дата создания бронирования.
     */
    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    /**
     * Дата истечения срока бронирования (например, 3 дня на подтверждение).
     */
    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    /**
     * Статус бронирования: ACTIVE, CANCELLED, EXPIRED, COMPLETED.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReservationStatus status;

    /**
     * Перечисление статусов бронирования.
     */
    public enum ReservationStatus {
        ACTIVE,
        CANCELLED,
        EXPIRED,
        COMPLETED
    }
}
