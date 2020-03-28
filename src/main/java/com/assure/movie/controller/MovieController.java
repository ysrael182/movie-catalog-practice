package com.assure.movie.controller;

import com.assure.movie.dto.BuilderMovieDTO;
import com.assure.movie.dto.MovieDTO;
import com.assure.movie.dto.domain.BuilderMovieModel;
import com.assure.movie.model.domain.Movie;
import com.assure.movie.service.MovieService;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Israel Yasis
 */
@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<MovieDTO> getMovie(@PathVariable Long movieId) {
        return new ResponseEntity<>(
                (new BuilderMovieDTO()).setMovieModel(this.movieService.getMovie(movieId)).build(),
                HttpStatus.OK
        );
    }
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> getMovies() {
        return null;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {
        Movie movieModel = (new BuilderMovieModel())
                .setMovieDTO(movieDTO).build();
        this.movieService.saveMovie(movieModel);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.PUT)

    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO, @PathVariable Long movieId) {
        Movie movieModel = this.movieService.getMovie(movieId);
        movieModel = (new BuilderMovieModel())
                        .setMovieDTO(movieDTO).setMovieModel(movieModel).build();
        this.movieService.saveMovie(movieModel);
        //this controller can return 200 ok with content ?
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }
}
