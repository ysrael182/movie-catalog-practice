package com.assure.movie.service;

import com.assure.movie.errors.NotFoundErrorException;
import com.assure.movie.model.domain.Movie;
import com.assure.movie.model.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Israel Yasis
 */
@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovie(Long id) throws NotFoundErrorException {
        return  this.movieRepository.findById(id).orElseThrow(()
                -> new NotFoundErrorException("Not found movie with id: "+ id));
    }
    public List<Movie> getMovies() {
        return this.movieRepository.findByDeleted(false);
    }
    @Transactional
    public Movie saveMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }
}
