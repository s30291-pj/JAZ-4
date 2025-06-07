package pl.edu.pjwstk.s30291.projects.svc.movie;

import java.time.LocalDate;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Schema(description = "Movie object used for basic movies control.")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Unique identifier of the movie.<br><b>(must be null during data creation)</b>", example = "d997ae27-0a0a-439d-a982-c37279aa0f39")
	private UUID id;
	
	@NotBlank
	@Setter 
	@Schema(description = "Date of movie publication")
	private LocalDate published;
	
	@NotBlank
	@Setter 
	@Schema(description = "Title of the movie")
	private String title;
	
	@NotBlank
	@Setter 
	@Schema(description = "Description of the movie")
	private String description;
	
	@NotBlank
	@Setter
	@Schema(description = "Category of the movie")
	private String category;
	
	@NotBlank
	@Setter 
	@Schema(description = "Author of the movie")
	private String author;
	
	@NotBlank
	@Setter
	@Schema(description = "Availability status of the movie")
	private boolean available;
}
