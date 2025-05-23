package pl.edu.pjwstk.s30291.projects.svc.movie.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.edu.pjwstk.s30291.projects.svc.movie.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
	public List<Movie> findAllByOrderByTitleAsc();
}
