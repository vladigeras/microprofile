package ru.vladigeras.microprofile.model;

import java.util.List;
import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Books POJO")
public class BookResponse {

    @JsonbProperty("books")
    @Schema(description = "Books list")
    private final List<Book> books;

    public BookResponse(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
