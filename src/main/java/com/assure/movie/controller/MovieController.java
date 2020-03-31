package com.assure.movie.controller;

import com.assure.movie.common.converter.ActorConverter;
import com.assure.movie.common.converter.MovieConverter;
import com.assure.movie.dto.ActorDTO;
import com.assure.movie.dto.MovieDTO;
import com.assure.movie.dto.domain.BuilderMovieModel;
import com.assure.movie.model.domain.Actor;
import com.assure.movie.model.domain.Movie;
import com.assure.movie.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Israel Yasis
 */
@RestController
@Api(tags = "Movies")
public class MovieController extends ApiController {

    private MovieService movieService;

    private MovieConverter movieConverter;

    private ActorConverter actorConverter;
    @Autowired
    public MovieController(
            MovieService movieService,
            MovieConverter movieConverter,
            ActorConverter actorConverter
    ) {
        this.movieService = movieService;
        this.movieConverter = movieConverter;
        this.actorConverter = actorConverter;
    }
    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<MovieDTO> getMovie(@PathVariable Long movieId) {
        MovieDTO movieDTO = this.movieConverter.createFrom(this.movieService.getMovie(movieId));
        return new ResponseEntity<>(
                movieDTO,
                HttpStatus.OK
        );
    }
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> getMovies() {
        List<Movie> movies = this.movieService.getMovies();
        List<MovieDTO> moviesDTO = new ArrayList<>();
        movies.forEach(movie -> {
            MovieDTO movieDTO = this.movieConverter.createFrom(movie);
            List<ActorDTO> actorsDTO =  this.actorConverter.createFromEntities(movie.getActors());
            movieDTO.setActors(actorsDTO);
            moviesDTO.add(movieDTO);
        });
        return  new ResponseEntity<>(
                moviesDTO,
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<MovieDTO> createMovie(@Valid @RequestBody MovieDTO movieDTO) {
        Movie movie = this.movieConverter.createFrom(movieDTO);
        List<Actor> actors = this.actorConverter.createFromDtos(movieDTO.getActors());
        if(actors.size() > 0) {
            movie.setActors(actors.stream().collect(Collectors.toSet()));
        }
        this.movieService.saveMovie(movie);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.PUT)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Not content")
    })
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO, @PathVariable Long movieId) {
        this.movieService.getMovie(movieId);
        Movie movie = this.movieConverter.createFrom(movieDTO);
        movie.setId(movieId);
        this.movieService.saveMovie(movie);
        //this controller can return 200 ok with content ?
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }
}
