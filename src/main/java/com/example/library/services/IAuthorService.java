package com.example.library.services;

import com.example.library.models.Author;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса для работы с авторами.
 * Определяет бизнес-логику управления сущностями Author.
 */
public interface IAuthorService {

    /**
     * Добавить нового автора.
     *
     * @param author объект автора
     * @return добавленный автор
     */
    Author addAuthor(Author author);

    /**
     * Получить список всех авторов.
     *
     * @return список авторов
     */
    List<Author> getAllAuthors();

    /**
     * Найти автора по идентификатору.
     *
     * @param id идентификатор автора
     * @return автор, если найден, иначе пустой Optional
     */
    Optional<Author> getAuthorById(Long id);

    /**
     * Удалить автора по идентификатору.
     *
     * @param id идентификатор автора
     */
    void deleteAuthor(Long id);

    /**
     * Обновить информацию об авторе.
     *
     * @param author объект автора с обновлёнными данными
     * @return обновлённый автор
     */
    Author updateAuthor(Author author);
}
