package com.assure.movie.service;

import com.assure.movie.model.domain.MovieRental;
import com.assure.movie.model.repository.MovieRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Israel Yasis
 */
@Service
public class MovieRentalService {

    private MovieRentalRepository movieRentalRepository;

    @Autowired
    public MovieRentalService(MovieRentalRepository movieRentalRepository) {
        this.movieRentalRepository = movieRentalRepository;
    }
    @Transactional
    public MovieRental saveMovieRental(MovieRental movieRental) {
        return this.movieRentalRepository.save(movieRental);
    }
}
