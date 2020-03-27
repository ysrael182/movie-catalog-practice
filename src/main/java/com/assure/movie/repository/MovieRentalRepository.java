package com.assure.movie.repository;

import com.assure.movie.model.MovieRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Israel Yasis
 */
@Repository
public interface MovieRentalRepository extends JpaRepository<MovieRental, Long> {
}
