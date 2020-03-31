package com.assure.movie.model.repository;

import com.assure.movie.model.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Israel Yasis
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public List<Movie> findByDeleted(boolean delete);
}
