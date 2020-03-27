package com.assure.movie.repository;

import com.assure.movie.model.MovieCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Israel Yasis
 */
@Repository
public interface MovieCatalogRepository extends JpaRepository<MovieCatalog, Long> {
}
