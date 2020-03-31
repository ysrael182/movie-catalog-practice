package com.assure.movie.controller;

import com.assure.movie.common.converter.MovieCatalogConverter;
import com.assure.movie.dto.MovieCatalogDTO;
import com.assure.movie.model.domain.Movie;
import com.assure.movie.model.domain.MovieCatalog;
import com.assure.movie.model.domain.Price;
import com.assure.movie.service.MovieCatalogService;
import com.assure.movie.service.MovieService;
import com.assure.movie.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Israel Yasis
 */
@RestController
public class MovieCatalogController extends ApiController {

    private PriceService priceService;
    private MovieService movieService;
    private MovieCatalogConverter movieCatalogConverter;
    private MovieCatalogService movieCatalogService;

    @Autowired
    public MovieCatalogController(
        MovieService movieService,
        PriceService priceService,
        MovieCatalogConverter movieCatalogConverter,
        MovieCatalogService movieCatalogService
    ) {
        this.movieService = movieService;
        this.priceService = priceService;
        this.movieCatalogConverter = movieCatalogConverter;
        this.movieCatalogService = movieCatalogService;
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
