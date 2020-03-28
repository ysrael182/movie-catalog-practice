package com.assure.movie.model.repository;

import com.assure.movie.model.domain.MovieRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Israel Yasis
 */
@Repository
public interface MovieRentalRepository extends JpaRepository<MovieRental, Long> {
}
