package pl.edu.pjwstk.s30291.jaz.zjazd4.movie;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Setter 
	private LocalDate published;
	
	@Setter 
	private String title;
	
	@Setter 
	private String description;
	
	@Setter 
	private String category;
	
	@Setter 
	private String author;
	
	@Setter
	private boolean available;
}
