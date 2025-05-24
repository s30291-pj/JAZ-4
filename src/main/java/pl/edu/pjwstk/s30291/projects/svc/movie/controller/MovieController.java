package pl.edu.pjwstk.s30291.projects.svc.movie.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.pjwstk.s30291.projects.svc.movie.Movie;
import pl.edu.pjwstk.s30291.projects.svc.movie.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private MovieService service;
	
	public MovieController(MovieService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getById(@PathVariable UUID id) {
		return ResponseEntity.of(service.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<Movie> create(@RequestBody Movie movie) {
		return ResponseEntity.ok(service.create(movie));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> update(@PathVariable UUID id, @RequestBody Movie movie) {
		return ResponseEntity.ok(service.update(id, movie));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/{id}/availability")
	public ResponseEntity<Movie> setAvailability(@PathVariable UUID id, @RequestBody boolean value) {
		service.setAvailability(id, value);
		
		return ResponseEntity.ok().build();
	}
}
