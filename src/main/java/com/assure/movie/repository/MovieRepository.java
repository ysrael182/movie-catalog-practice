package com.assure.movie.repository;

import com.assure.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Israel Yasis
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
