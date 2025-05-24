package pl.edu.pjwstk.s30291.projects.svc.movie.exception;

import java.util.UUID;

public class MovieNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 4534826086841704600L;

	public MovieNotFoundException(UUID uuid) {
		super("Nie znaleziono filmu o podanym ID (%s)".formatted(uuid));
	}
}
