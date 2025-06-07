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

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import pl.edu.pjwstk.s30291.projects.svc.movie.Movie;
import pl.edu.pjwstk.s30291.projects.svc.movie.service.MovieService;

@OpenAPIDefinition(
		info = @Info(
			title = "Movie Service", 
			description = "This is a movie service API that can be used to fetch/create/update movies as also change specific parameters like availability."
			)
		)

@RestController
@RequestMapping("/movies")
@Tag(name = "Basic Operations - Movie Controller", description = "This controller provides basic data control.")
public class MovieController {
	private MovieService service;
	
	public MovieController(MovieService service) {
		this.service = service;
	}
	
	@Operation(summary = "Fetch all movies")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Successfuly fetched all movies", 
	    content = { @Content(mediaType = "application/json", 
	      array = @ArraySchema(schema = @Schema(implementation = Movie.class))) })
	})
	@GetMapping
	public ResponseEntity<List<Movie>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@Operation(summary = "Fetch movie with ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Successfuly fetch movie with provided ID", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Movie.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID provided", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Movie with provided ID not found", 
	    content = @Content) })
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getById(@PathVariable UUID id) {
		return ResponseEntity.of(service.getById(id));
	}
	
	@Operation(summary = "Create movie")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Movie stored in database", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Movie.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid request provided", 
			    content = @Content)})
	@PostMapping
	public ResponseEntity<Movie> create(@RequestBody Movie movie) {
		return ResponseEntity.ok(service.create(movie));
	}
	
	@Operation(summary = "Update movie with ID")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Movie updated successfuly", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Movie.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid ID/request provided", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Movie with provided ID not found", 
			    content = @Content) })
	@PutMapping("/{id}")
	public ResponseEntity<Movie> update(@PathVariable UUID id, @RequestBody Movie movie) {
		return ResponseEntity.ok(service.update(id, movie));
	}
	
	@Operation(summary = "Delete movie with provided ID")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "204", description = "Movie deleted successfuly", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Movie.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid ID provided", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Movie with provided ID not found", 
			    content = @Content) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@Operation(summary = "Change movie with provided ID availability")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Movie availability changed successfuly", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Movie.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid ID provided", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Movie with provied ID not found", 
			    content = @Content) })
	@PostMapping("/{id}/availability")
	public ResponseEntity<Movie> setAvailability(@PathVariable UUID id, @RequestBody boolean value) {
		service.setAvailability(id, value);
		
		return ResponseEntity.ok().build();
	}
}
