package ru.vladigeras.microprofile.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Book POJO")
public class Book {

	@JsonbProperty("id")
	@Schema(description = "book id")
	private final String id;

	@JsonbProperty("title")
	@Schema(description = "book title")
	private final String title;

	@JsonbCreator
	public Book(@JsonbProperty("id") String id, @JsonbProperty("title") String title) {
		this.id = id;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
}
