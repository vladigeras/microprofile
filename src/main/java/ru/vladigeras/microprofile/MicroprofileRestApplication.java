package ru.vladigeras.microprofile;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import ru.vladigeras.microprofile.controller.BookController;

@ApplicationPath("/api")
@ApplicationScoped
public class MicroprofileRestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(BookController.class);
		return classes;
	}
}
