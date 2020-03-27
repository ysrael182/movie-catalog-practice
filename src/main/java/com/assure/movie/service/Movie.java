package com.assure.movie.service;

import com.assure.movie.common.dto.BuilderMovieDTO;
import com.assure.movie.common.dto.MovieDTO;
import com.assure.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author Israel Yasis
 */
@Service
public class Movie {

    private MovieRepository movieRepository;

    @Autowired
    public Movie(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public MovieDTO getMovie(Long id) {
        BuilderMovieDTO builderMovieDTO = new BuilderMovieDTO();
        movieRepository.findById(id);
        return builderMovieDTO.build();
    }
}
