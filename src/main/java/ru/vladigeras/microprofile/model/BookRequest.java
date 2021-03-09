package ru.vladigeras.microprofile.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Add/Edit Book request POJO")
public class BookRequest {

	@JsonbProperty("title")
	@Schema(description = "book title")
	private final String title;

	@JsonbCreator
	public BookRequest(@JsonbProperty("title") String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
