package ru.vladigeras.microprofile.service.impl;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.enterprise.context.ApplicationScoped;
import ru.vladigeras.microprofile.model.Book;
import ru.vladigeras.microprofile.model.BookRequest;
import ru.vladigeras.microprofile.model.BookResponse;
import ru.vladigeras.microprofile.service.BookService;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    private final Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public BookResponse find(String title) {
        List<Book> result = isNull(title) ? new ArrayList<>(this.books.values())
            : this.books.values().stream().filter(book -> book.getTitle().contains(title)).collect(
                toList());
        return new BookResponse(result);
    }

    @Override
    public void save(String id, BookRequest book) {
        String bookId = nonNull(id) ? id : UUID.randomUUID().toString();
        books.put(bookId, new Book(bookId, book.getTitle()));
    }

    @Override
    public void delete(String id) {
        books.remove(id);
    }
}
