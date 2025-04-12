package pl.edu.pjwstk.s30291.jaz.zjazd4.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import pl.edu.pjwstk.s30291.jaz.zjazd4.movie.Movie;
import pl.edu.pjwstk.s30291.jaz.zjazd4.movie.exception.MovieNotFoundException;
import pl.edu.pjwstk.s30291.jaz.zjazd4.movie.exception.MovieNotFoundException;
import pl.edu.pjwstk.s30291.jaz.zjazd4.movie.repository.MovieRepository;

@Service
public class MovieService {
	private MovieRepository repository;
	
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}
	
	public List<Movie> getAll() {
		return repository.findAll();
	}
	
	public Optional<Movie> getById(UUID id) {
		return repository.findById(id);
	}
	
	public Movie create(Movie movie) {
		if(movie.getId() != null) throw new IllegalArgumentException("Nie można przekazywać ID obiektu!");
		
		return repository.save(movie);
	}
	
	public Movie update(UUID id, Movie movie) {
		if(movie.getId() != null) throw new IllegalArgumentException("Nie można przekazywać ID obiektu!");

		if(!exists(id)) throw new MovieNotFoundException(movie.getId());
		
		return repository.save(movie);
	}
	
	public void delete(UUID id) {
		if(!exists(id)) throw new MovieNotFoundException(id);
		
		repository.deleteById(id);
	}
	
	public boolean exists(UUID id) {
		return repository.existsById(id);
	}
	
	public boolean exists(Movie movie) {
		if(movie.getId() == null) throw new IllegalArgumentException("Nie wprowadzono ID filmu!");
		
		return exists(movie.getId());
	}
}
