package pl.edu.pjwstk.s30291.jaz.zjazd4.movie.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.edu.pjwstk.s30291.jaz.zjazd4.movie.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

}
