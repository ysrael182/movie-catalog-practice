package com.assure.movie.service;

import com.assure.movie.common.errors.NotFoundErrorException;
import com.assure.movie.model.domain.Movie;
import com.assure.movie.model.domain.MovieCatalog;
import com.assure.movie.model.domain.Price;
import com.assure.movie.model.repository.MovieCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Israel Yasis
 */
@Service
public class MovieCatalogService {

    private MovieCatalogRepository movieCatalogRepository;

    private MovieService movieService;

    private PriceService priceService;

    @Autowired
    public MovieCatalogService(
        MovieCatalogRepository movieCatalogRepository,
        MovieService movieService,
        PriceService priceService
    ) {
        this.movieService = movieService;
        this.priceService = priceService;
        this.movieCatalogRepository = movieCatalogRepository;
    }

    @Transactional
    public MovieCatalog saveMovieCatalog(MovieCatalog movieCatalog) {
        return this.movieCatalogRepository.save(movieCatalog);
    }

    @Transactional
    public MovieCatalog createMovieCatalog(
        MovieCatalog movieCatalog,
        Long movieId,
        Long priceId
    ) throws NotFoundErrorException {
        Movie movie = this.movieService.getMovie(movieId);
        Price price = this.priceService.getPrice(priceId);
        movieCatalog.setMovie(movie);
        movieCatalog.setPrice(price);
        return this.movieCatalogRepository.save(movieCatalog);
    }
}
