package com.assure.movie.controller;

import com.assure.movie.common.converter.MovieCatalogConverter;
import com.assure.movie.dto.MovieCatalogDTO;
import com.assure.movie.model.domain.MovieCatalog;
import com.assure.movie.service.MovieCatalogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Israel Yasis
 */
@RestController
@Api(tags = "Catalog of Movies")
public class MovieCatalogController extends ApiController {

    private MovieCatalogConverter movieCatalogConverter;
    private MovieCatalogService movieCatalogService;

    @Autowired
    public MovieCatalogController(
        MovieCatalogConverter movieCatalogConverter,
        MovieCatalogService movieCatalogService
    ) {
        this.movieCatalogConverter = movieCatalogConverter;
        this.movieCatalogService = movieCatalogService;
    }

    @RequestMapping(value = "/catalog-entries/", method = RequestMethod.GET)
    public ResponseEntity<List<MovieCatalogDTO>> getCatalogMovies() {
        List<MovieCatalog> movieCatalogs = this.movieCatalogService.getMovieCatalogs();
        List<MovieCatalogDTO> MovieCatalogDTOS = this.movieCatalogConverter.createFromEntities(movieCatalogs);
        return new ResponseEntity<>(
                MovieCatalogDTOS,
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/catalog-entries/", method = RequestMethod.POST)
    public ResponseEntity<MovieCatalogDTO> saveMovieCatalog(
        @RequestBody MovieCatalogDTO movieCatalogDTO
    ) {
        MovieCatalog movieCatalog =  this.movieCatalogConverter.createFrom(movieCatalogDTO);
        this.movieCatalogService.createMovieCatalog(movieCatalog, movieCatalogDTO.getMovieId(), movieCatalogDTO.getPriceId());
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

}
