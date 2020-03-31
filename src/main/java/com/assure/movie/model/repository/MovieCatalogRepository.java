package com.assure.movie.model.repository;

import com.assure.movie.model.domain.MovieCatalog;
import com.assure.movie.model.domain.embedable.MovieCatalogId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Israel Yasis
 */
@Repository
public interface MovieCatalogRepository extends JpaRepository<MovieCatalog, MovieCatalogId> {
}
