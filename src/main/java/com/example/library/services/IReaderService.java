package com.example.library.services;

import com.example.library.models.Reader;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса для работы с читателями.
 * Определяет бизнес-логику управления сущностями Reader.
 */
public interface IReaderService {

    /**
     * Зарегистрировать нового читателя.
     *
     * @param reader объект читателя
     * @return добавленный читатель
     */
    Reader addReader(Reader reader);

    /**
     * Получить список всех зарегистрированных читателей.
     *
     * @return список читателей
     */
    List<Reader> getAllReaders();

    /**
     * Найти читателя по идентификатору.
     *
     * @param id идентификатор читателя
     * @return читатель, если найден, иначе пустой Optional
     */
    Optional<Reader> getReaderById(Long id);

    /**
     * Удалить читателя по идентификатору.
     *
     * @param id идентификатор читателя
     */
    void deleteReader(Long id);

    /**
     * Обновить данные о читателе.
     *
     * @param reader объект читателя с обновлёнными данными
     * @return обновлённый читатель
     */
    Reader updateReader(Reader reader);
}
