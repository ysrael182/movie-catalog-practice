package com.assure.movie.service;

import com.assure.movie.model.domain.MovieCatalog;
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

    @Autowired
    public MovieCatalogService(MovieCatalogRepository movieCatalogRepository) {
        this.movieCatalogRepository = movieCatalogRepository;
    }
    @Transactional
    public MovieCatalog saveMovieCatalog(MovieCatalog movieCatalog) {
        return this.movieCatalogRepository.save(movieCatalog);
    }
}
