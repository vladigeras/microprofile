package ru.vladigeras.microprofile.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import ru.vladigeras.microprofile.model.BookRequest;
import ru.vladigeras.microprofile.model.BookResponse;
import ru.vladigeras.microprofile.service.BookService;

@Path("/v1/books")
@ApplicationScoped
public class BookController {

	private final BookService bookService;

	@Inject
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GET
	@Operation(summary = "Get books")
	public BookResponse get(
		@Parameter(description = "Book title") @QueryParam("title") String title) {
		return bookService.find(title);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Operation(summary = "Add book")
	public Response add(BookRequest book) {
		bookService.save(null, book);
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Path("/{id}")
	@Operation(summary = "Edit book")
	public Response edit(@Parameter(description = "Book id") @PathParam("id") String id,
		BookRequest book) {
		bookService.save(id, book);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	@Operation(summary = "Delete book")
	public Response delete(@Parameter(description = "Book id") @PathParam("id") String id) {
		bookService.delete(id);
		return Response.ok().build();
	}
}
