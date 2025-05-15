package com.example.library.repositories;

import com.example.library.models.Reservation;
import com.example.library.models.Reservation.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * ReservationRepository — интерфейс для работы с таблицей reservations в базе данных.
 * Использует Spring Data JPA для автоматической генерации SQL-запросов.
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    /**
     * Найти все бронирования по читателю.
     *
     * @param readerId ID читателя.
     * @return список бронирований.
     */
    List<Reservation> findByReaderId(Long readerId);

    /**
     * Найти все бронирования по книге.
     *
     * @param bookId ID книги.
     * @return список бронирований.
     */
    List<Reservation> findByBookId(Long bookId);

    /**
     * Найти все активные бронирования книги.
     *
     * @param bookId ID книги.
     * @param status Статус бронирования (обычно ACTIVE).
     * @return список активных бронирований.
     */
    List<Reservation> findByBookIdAndStatus(Long bookId, ReservationStatus status);

    /**
     * Найти все бронирования с истекшим сроком.
     *
     * @param expirationDate Дата, раньше которой бронирование считается просроченным.
     * @param status         Статус бронирования (обычно ACTIVE).
     * @return список просроченных бронирований.
     */
    List<Reservation> findByExpirationDateBeforeAndStatus(LocalDate expirationDate, ReservationStatus status);
}
