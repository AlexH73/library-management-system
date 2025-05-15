package com.example.library.services;

import com.example.library.models.Loan;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса для управления займами книг (Loan).
 * Определяет бизнес-логику обработки выдачи и возврата книг.
 */
public interface ILoanService {

    /**
     * Создать новый займ книги.
     *
     * @param loan объект займа
     * @return добавленный займ
     */
    Loan addLoan(Loan loan);

    /**
     * Получить список всех займов.
     *
     * @return список займов
     */
    List<Loan> getAllLoans();

    /**
     * Найти займ по идентификатору.
     *
     * @param id идентификатор займа
     * @return займ, если найден, иначе пустой Optional
     */
    Optional<Loan> getLoanById(Long id);

    /**
     * Завершить займ (вернуть книгу).
     *
     * @param id идентификатор займа
     * @return обновленный займ со статусом "returned"
     */
    Loan returnLoan(Long id);

    /**
     * Удалить запись о займе по идентификатору.
     *
     * @param id идентификатор займа
     */
    void deleteLoan(Long id);
}

