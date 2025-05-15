package com.example.library.repositories;

import com.example.library.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий для работы с сущностью Loan (выдача книг) в базе данных.
 * Наследуется от JpaRepository, предоставляет CRUD-операции и возможность написания кастомных методов.
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    /**
     * Найти все займы по идентификатору читателя.
     *
     * @param readerId ID читателя
     * @return список займов, связанных с этим читателем
     */
    List<Loan> findByReaderId(Long readerId);

    /**
     * Найти активный заем книги по ID книги и ID читателя.
     *
     * @param bookId   ID книги
     * @param readerId ID читателя
     * @return Optional с займом, если найден
     */
    Optional<Loan> findByBookIdAndReaderIdAndReturnDateIsNull(Long bookId, Long readerId);

    /**
     * Найти все активные (не возвращённые) займы.
     *
     * @return список активных займов
     */
    List<Loan> findByReturnDateIsNull();
}
