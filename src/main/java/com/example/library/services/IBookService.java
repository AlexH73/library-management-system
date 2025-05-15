package com.example.library.services;

import com.example.library.models.Book;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса для работы с книгами.
 * Описывает бизнес-логику, не зависящую от типа хранения данных.
 */
public interface IBookService {

    /**
     * Добавить новую книгу в библиотеку.
     *
     * @param book объект книги
     * @return добавленная книга
     */
    Book addBook(Book book);

    /**
     * Получить список всех книг.
     *
     * @return список книг
     */
    List<Book> getAllBooks();

    /**
     * Найти книгу по идентификатору.
     *
     * @param id идентификатор книги
     * @return книга, если найдена, иначе пустой Optional
     */
    Optional<Book> getBookById(Long id);

    /**
     * Удалить книгу по идентификатору.
     *
     * @param id идентификатор книги
     */
    void deleteBook(Long id);

    /**
     * Обновить информацию о книге.
     *
     * @param book книга с обновлёнными данными
     * @return обновлённая книга
     */
    Book updateBook(Book book);
}

