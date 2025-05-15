package com.example.library.services;

import com.example.library.models.Reservation;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса для управления бронированием книг (Reservation).
 * Определяет бизнес-логику создания, поиска и отмены бронирований.
 */
public interface IReservationService {

    /**
     * Создать новую бронь на книгу.
     *
     * @param reservation объект бронирования
     * @return созданная бронь
     */
    Reservation addReservation(Reservation reservation);

    /**
     * Получить список всех бронирований.
     *
     * @return список бронирований
     */
    List<Reservation> getAllReservations();

    /**
     * Найти бронирование по идентификатору.
     *
     * @param id идентификатор бронирования
     * @return бронь, если найдена, иначе пустой Optional
     */
    Optional<Reservation> getReservationById(Long id);

    /**
     * Отменить бронирование по идентификатору.
     *
     * @param id идентификатор бронирования
     */
    void cancelReservation(Long id);
}
