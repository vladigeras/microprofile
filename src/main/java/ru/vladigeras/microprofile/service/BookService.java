package ru.vladigeras.microprofile.service;

import ru.vladigeras.microprofile.model.BookRequest;
import ru.vladigeras.microprofile.model.BookResponse;

public interface BookService {

	BookResponse find(String title);

	void save(String id, BookRequest book);

	void delete(String id);
}
