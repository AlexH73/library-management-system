package com.example.library.repositories;

import com.example.library.models.Reader;

import java.util.List;
import java.util.Optional;

/**
 * 🗂️ ReaderRepository — интерфейс для управления сущностями Reader в базе данных.
 * <p>
 * 📊 Отвечает за:
 * - сохранение нового читателя;
 * - получение списка всех читателей;
 * - поиск читателя по ID;
 * - удаление читателя по ID.
 * <p>
 * 🔹 Связь:
 * - Работает с сущностью {@link Reader}.
 * - Реализация будет использоваться в слое сервиса (Service Layer).
 */
public interface ReaderRepository {

    /**
     * 💾 Сохраняет нового читателя в базу данных.
     *
     * @param reader Объект {@link Reader} для сохранения.
     * @return Сохранённый объект Reader с присвоенным ID.
     */
    Reader save(Reader reader);

    /**
     * 📄 Возвращает список всех зарегистрированных читателей.
     *
     * @return Список объектов {@link Reader}.
     */
    List<Reader> findAll();

    /**
     * 🔍 Ищет читателя по уникальному идентификатору.
     *
     * @param id Уникальный идентификатор читателя.
     * @return Optional с объектом {@link Reader}, если найден.
     */
    Optional<Reader> findById(Long id);

    /**
     * 🗑️ Удаляет читателя по его идентификатору.
     *
     * @param id Уникальный идентификатор читателя для удаления.
     */
    void deleteById(Long id);
}
